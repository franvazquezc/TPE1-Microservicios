package com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model;

import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private int kilometros;

    @Column(nullable = false)
    private int dinero;

    @Column(nullable = false)
    private boolean premiun = false;

    @Column(nullable = false)
    private boolean activa = true;

    @Column(nullable = false)
    @OneToMany(mappedBy = "Usuario")
    private List<Usuario> usuarios;
}
