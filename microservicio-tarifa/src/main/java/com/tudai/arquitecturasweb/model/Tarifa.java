package com.tudai.arquitecturasweb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    /*es necesario?*/private int precioPorMinuto = 0;
    @Column(nullable = false)
    private int precioPorKilometro;
    @Column(nullable = false)
    private int extraPorPausa;
    @Column(nullable = false)
    private LocalDate fechaTarifa;
}
