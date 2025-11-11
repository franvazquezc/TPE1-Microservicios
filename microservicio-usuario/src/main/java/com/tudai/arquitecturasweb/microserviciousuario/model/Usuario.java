package com.tudai.arquitecturasweb.microserviciousuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Column(nullable = false)
    int dni;

    @Column(nullable = false)
    String alias;

    @Column(nullable = false)
    String nombre;

    @Column(nullable = false)
    String apellido;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    int celular;

    @OneToMany(mappedBy = "cuenta")
    List<Cuenta>cuentas;

}
