package com.example.delivery.repository;

import com.example.delivery.model.EPerfilUsuario;
import com.example.delivery.model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<PerfilUsuario, Long> {
    Optional<PerfilUsuario> findByName(EPerfilUsuario name);
}
