package com.tudai.arquitecturasweb.microservicioviaje.repository;

import com.tudai.arquitecturasweb.microservicioviaje.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface repositoryViaje extends JpaRepository<Viaje, Integer> {

    @Query("SELECT v.monopatinId FROM Viaje v WHERE FUNCTION('year', v.fechaViaje) = :anio GROUP BY v.monopatinId " +
            "HAVING COUNT(v) > :veces")
    List<Integer> viajesXMonopatin(int veces, int anio);

}
