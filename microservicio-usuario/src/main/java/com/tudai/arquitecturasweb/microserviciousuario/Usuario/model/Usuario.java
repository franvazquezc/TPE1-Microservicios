package com.tudai.arquitecturasweb.microserviciousuario.Usuario.model;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
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

    @Column(nullable = false)
    double latitud;

    @Column(nullable = false)
    double longitud;

    @ManyToMany(mappedBy = "Usuario")
    @JoinTable(
            name = "usuario_cuenta",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "cuenta_id")
    )
    List<Cuenta>cuentas;

}
