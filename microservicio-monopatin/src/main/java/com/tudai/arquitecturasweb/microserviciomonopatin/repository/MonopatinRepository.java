package com.tudai.arquitecturasweb.microserviciomonopatin.repository;

import com.tudai.arquitecturasweb.microserviciomonopatin.DTO.monopatinDTO;
import com.tudai.arquitecturasweb.microserviciomonopatin.entity.Monopatin;

import com.tudai.arquitecturasweb.model.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonopatinRepository extends JpaRepository<Monopatin, Integer> {

    /*pasar a lista*/
    @Query("SELECT new com.tudai.arquitecturasweb.microserviciomonopatin.DTO.monopatinDTO(m.activo, m.latitud, m.longitud, m.estado) FROM Monopatin m WHERE m.idParadaActual = :id")
    List<Monopatin> findByIdParadaActual(int id);

    @Query("SELECT new com.tudai.arquitecturasweb.microserviciomonopatin.DTO.monopatinDTO(m.activo, m.latitud, m.longitud, m.estado) FROM " +
            "Monopatin m WHERE m.kmRecorridos = :km AND m.minutosDeUso = :min AND m.estado IN (com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin.PAUSA, " +
            "com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin.EN_USO)")
    List<monopatinDTO> reporteMonopatinKilometrosYTiempo(int km, int min);

}
