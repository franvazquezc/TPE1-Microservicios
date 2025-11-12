package com.tudai.arquitecturasweb.microservicioviaje.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fechaViaje;
    private int horaInicio;
    private int horaFin;
    private int monopatinId;
    private int destinoId;
    private int origenId;

    private int idUsuario;

    private int kilometros = 0;


}
