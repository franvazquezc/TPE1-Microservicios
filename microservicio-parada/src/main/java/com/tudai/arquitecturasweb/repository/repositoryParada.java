package com.tudai.arquitecturasweb.repository;

import com.tudai.arquitecturasweb.model.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoryParada extends JpaRepository<Parada, Integer> {
}
