package org.seguridad.seguridad.controllers;

import org.seguridad.seguridad.models.LoginRequest;
import org.seguridad.seguridad.models.Usuarios;
import org.seguridad.seguridad.service.UsuariosServices;
import org.seguridad.seguridad.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"*"})
public class AuthController {
    private final UsuariosServices services;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UsuariosServices services, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
        this.services = services;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuarios> usersCreate(@RequestBody Usuarios users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Usuarios user = services.createUsers(users);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> usersLogin(@RequestBody LoginRequest request, SessionStatus sessionStatus){
        Optional<Usuarios> optionalUsers = services.findUsersByUsername(request.getUsername());

        if(optionalUsers.isPresent() && passwordEncoder.matches(request.getPassword(), optionalUsers.get().getPassword())){
            String token = jwtUtils.generateToken(optionalUsers.get().getUsername());
            return ResponseEntity.ok(token);
        }
        else {
            return ResponseEntity.status(401).body("Credenciales invalidas");
        }
    }
}
