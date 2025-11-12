package com.tudai.arquitecturasweb.microserviciousuario.Cuenta.controller;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.service.cuentaService;
import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class cuentaController {

    @Autowired
    cuentaService cuentaService;

    @GetMapping
    public List<Cuenta> getPagos(){
        return cuentaService.getAll();
    }

    @GetMapping("/{id}")
    public Cuenta getPagoById(@PathVariable int id){
        return cuentaService.getCuentaById(id);
    }

    @PostMapping("")
    public Cuenta createPago(@RequestBody Cuenta cuenta){
        return cuentaService.save(cuenta);
    }

    @DeleteMapping("/{id}")
    public void deletePago(@PathVariable int id){
        cuentaService.delete(id);
    }

    @PutMapping("/anular/{id}")
    public ResponseEntity<Void> anular(@PathVariable int id){
        cuentaService.anularCuenta(id);
        return ResponseEntity.noContent().build();
    }
}