package com.tudai.arquitecturasweb.microserviciousuario.Cuenta.repository;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cuentaRepository extends JpaRepository<Cuenta, Integer> {
}
