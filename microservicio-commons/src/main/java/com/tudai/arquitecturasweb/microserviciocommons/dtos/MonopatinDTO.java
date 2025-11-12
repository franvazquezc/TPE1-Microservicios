package com.tudai.arquitecturasweb.microserviciocommons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonopatinDTO {

    private boolean activo;
    private long minutosDeUso;
    private double kilometros;
    private long latitud;
    private long longitud;


}
