package com.tudai.arquitecturasweb.microserviciousuario.Usuario.repository;


import com.tudai.arquitecturasweb.microserviciocommons.dtos.UsuariosConMasViajesDTO;
import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
