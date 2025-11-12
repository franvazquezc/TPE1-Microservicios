package com.tudai.arquitecturasweb.microserviciomonopatin.DTO;

import com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonopatinDisponibleDTO {

    private int id;
    private EstadoMonopatin estado;
    private double latitud;
    private double longitud;
    private int paradaActual;

}
