package org.seguridad.seguridad.repository;

import org.seguridad.seguridad.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarios extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsername(String username);
}
