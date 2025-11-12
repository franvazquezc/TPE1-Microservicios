package com.tudai.arquitecturasweb.repository;

import com.tudai.arquitecturasweb.DTO.FacturaDTO;
import com.tudai.arquitecturasweb.DTO.TarifaDTO;
import com.tudai.arquitecturasweb.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface repositoryTarifa extends JpaRepository<Tarifa, Integer> {

    @Query("SELECT new com.tudai.arquitecturasweb.DTO.FacturaDTO(SUM(t.precioPorKilometro + t.extraPorPausa + t.precioPorMinuto), :mesInicio, :mesFin, :anio) FROM Tarifa t " +
            "WHERE FUNCTION('year', t.fechaTarifa) = :anio " +
            "AND FUNCTION('month', t.fechaTarifa) >= :mesInicio " +
            "AND FUNCTION('month', t.fechaTarifa) <= :mesFin")
    FacturaDTO obtenerTotalFacturado(
            @Param("mesInicio") int mesInicio,
            @Param("mesFin") int mesFin,
            @Param("anio") int anio);

    @Query("SELECT t FROM Tarifa t WHERE " +
            "t.fechaTarifa <= :fechaCorte " +
            "ORDER BY t.fechaTarifa DESC " +
            "LIMIT 1")
    public Optional<Tarifa> encontrarTarifaPorCorte(@Param("fechaCorte") LocalDate fechaCorte);
}
