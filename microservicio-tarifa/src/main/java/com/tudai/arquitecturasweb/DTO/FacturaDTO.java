package com.tudai.arquitecturasweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private int totalFacturado;
    private int mesInicio;
    private int mesFim;
    private int anio;

}
