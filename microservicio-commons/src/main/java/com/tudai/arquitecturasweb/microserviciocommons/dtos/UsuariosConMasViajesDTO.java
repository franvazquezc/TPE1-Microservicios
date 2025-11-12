package com.tudai.arquitecturasweb.microserviciocommons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosConMasViajesDTO {
    int id;
    LocalDate inicio;
    LocalDate fin;
    int cantidadViajes;

}
