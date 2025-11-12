package com.tudai.arquitecturasweb.microserviciomonopatin.DTO;

import com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class monopatinDTO {
    private boolean activo;
    private double latitud;
    private double longitud;
    private EstadoMonopatin estado;

}
