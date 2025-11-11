package com.tudai.arquitecturasweb.microserviciopago.repository;

import com.tudai.arquitecturasweb.microserviciopago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pagoRepository extends JpaRepository<Pago, Integer> {
}
