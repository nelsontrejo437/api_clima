package org.seguridad.seguridad.controllers;

import org.seguridad.seguridad.models.RegistroConsulta;
import org.seguridad.seguridad.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    private final UsuariosServices services;

    @Autowired
    public ConsultasController(final UsuariosServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public List<RegistroConsulta> getConsultasByUsers(){
        String Users = services.getCurrentUsers();
       return services.findConsultasByUsername(Users);
    }
}
