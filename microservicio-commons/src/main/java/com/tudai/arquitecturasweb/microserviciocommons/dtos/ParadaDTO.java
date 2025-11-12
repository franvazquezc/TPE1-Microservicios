package com.tudai.arquitecturasweb.microserviciocommons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParadaDTO {

    private String nombre;
    private String descripcion;
    private int latitud;
    private int longitud;

}