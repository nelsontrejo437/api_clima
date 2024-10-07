package org.seguridad.seguridad.repository;

import org.seguridad.seguridad.models.RegistroConsulta;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface IRegistroConsulta extends JpaRepository<RegistroConsulta, Long> {
    List<RegistroConsulta> findByUsername(String username);
}
