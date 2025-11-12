package com.tudai.arquitecturasweb.microserviciousuario.Usuario.repository;


import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
