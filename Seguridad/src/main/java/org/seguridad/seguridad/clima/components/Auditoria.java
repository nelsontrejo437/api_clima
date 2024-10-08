package org.seguridad.seguridad.clima.components;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.seguridad.seguridad.models.RegistroConsulta;
import org.seguridad.seguridad.repository.IRegistroConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class Auditoria {
    private final IRegistroConsulta repo;

    @Autowired
    public Auditoria(IRegistroConsulta repo) {
        this.repo = repo;
    }

    @Around(value = "execution(* org.seguridad.seguridad.clima.controllers.ClimaController.*(..))")
    public Object audit(ProceedingJoinPoint join) throws Throwable {
        String consulta = join.getSignature().toShortString();

        Object resultado = join.proceed();
        String respuesta = resultado != null ? resultado.toString() : "sin respuesta";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth != null ? auth.getName() : "anonimo";

        RegistroConsulta registro = new RegistroConsulta();
        registro.setConsulta(consulta);
        registro.setRespuesta(respuesta);
        registro.setFecha_consulta(LocalDateTime.now());
        registro.setUsername(username);
        repo.save(registro);
        System.out.println("registro: " + registro);
        return resultado;
    }

    public void saveRegister(RegistroConsulta regis){
        repo.save(regis);
    }
}
