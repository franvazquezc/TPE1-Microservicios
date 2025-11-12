package com.tudai.arquitecturasweb.microservicioviaje.repository;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.UsuariosConMasViajesDTO;
import com.tudai.arquitecturasweb.microservicioviaje.dto.usoCuentaDTO;
import com.tudai.arquitecturasweb.microservicioviaje.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface repositoryViaje extends JpaRepository<Viaje, Integer> {

    @Query("SELECT v.monopatinId FROM Viaje v WHERE FUNCTION('year', v.fechaViaje) = :anio GROUP BY v.monopatinId " +
            "HAVING COUNT(v) > :veces")
    List<Integer> viajesXMonopatin(@Param("veces") int veces, @Param("anio") int anio);

    @Query("SELECT new com.tudai.arquitecturasweb.microserviciocommons.dtos.UsuariosConMasViajesDTO(v.idUsuario, :inicio,  :fin, COUNT(v.id)) " +
            "FROM Viaje v " +
            "WHERE v.fechaViaje BETWEEN :inicio AND :fin " +
            "GROUP BY v.idUsuario " +
            "ORDER BY COUNT(v.id) DESC")
    List<UsuariosConMasViajesDTO> optenerUsuariosMasMonopatines(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    @Query("SELECT new com.tudai.arquitecturasweb.microservicioviaje.dto.usoCuentaDTO(SUM(v.horaInicio + v.horaFin), SUM(v.kilometros), COUNT(v.id)) " +
            "FROM Viaje v WHERE " +
            "v.idUsuario = :idUsuario AND " +
            "v.fechaViaje BETWEEN :fechaInicio AND :fechaFin GROUP BY v.idUsuario")
    usoCuentaDTO obtenerTopUsuarios(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin, @Param("idUsuario") int idUsuario);
}
