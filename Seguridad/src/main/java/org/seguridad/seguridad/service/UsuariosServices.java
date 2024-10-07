package org.seguridad.seguridad.service;

import org.seguridad.seguridad.models.RegistroConsulta;
import org.seguridad.seguridad.models.Usuarios;
import org.seguridad.seguridad.repository.IRegistroConsulta;
import org.seguridad.seguridad.repository.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServices {
    private final IUsuarios repo;
    private final IRegistroConsulta regConsulta;

    @Autowired
    public UsuariosServices(IUsuarios repo, IRegistroConsulta regConsulta) {
        this.repo = repo;
        this.regConsulta = regConsulta;
    }

    public Usuarios createUsers(Usuarios users) {
        users.setPassword(users.getPassword());
        return repo.save(users);
    }

    public Optional<Usuarios> findUsersByUsername(String username) {
        return repo.findByUsername(username);
    }

    public String getCurrentUsers(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        }
        else {
            return principal.toString();
        }
    }

    public List<RegistroConsulta> findConsultasByUsername(String username) {
        return regConsulta.findByUsername(username);
    }
}
