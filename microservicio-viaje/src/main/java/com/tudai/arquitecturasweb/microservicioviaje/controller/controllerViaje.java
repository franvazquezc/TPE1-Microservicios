package com.tudai.arquitecturasweb.microservicioviaje.controller;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.MonopatinDTO;
import com.tudai.arquitecturasweb.microserviciocommons.dtos.UsuariosConMasViajesDTO;
import com.tudai.arquitecturasweb.microservicioviaje.model.Viaje;
import com.tudai.arquitecturasweb.microservicioviaje.service.serviceViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/viaje")
public class controllerViaje {

    @Autowired
    public serviceViaje serviceViaje;

    @GetMapping("")
    public ResponseEntity<List<Viaje>> getServiceViaje() {
        return ResponseEntity.ok(serviceViaje.findAll());
    }

    @PutMapping("")
    public void addViaje(Viaje viaje) {
        serviceViaje.save(viaje);
    }

    @DeleteMapping("/{id}")
    public void deleteViaje(@PathVariable int id) {
        serviceViaje.delete(id);
    }

    @PostMapping("/{id}")
    public void updateViaje(@RequestBody Viaje viaje, @PathVariable int id) {
        serviceViaje.update(id, viaje);
    }

    @GetMapping("/{id}")
    public Viaje getViaje(@PathVariable int id) {
        return serviceViaje.findById(id);
    }

    @GetMapping("/monopatin/{id}")
    public ResponseEntity<List<MonopatinDTO>> getMonopatinXViajeXAño(@PathVariable int idMonopatin, @RequestParam int cantidad, @RequestParam int anio) {
        return ResponseEntity.ok(serviceViaje.getMonopatinesViajeXAño(anio, cantidad));
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuariosConMasViajesDTO>> getUsuariosConMasViajes(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) {
        return ResponseEntity.ok(serviceViaje.getUsuariosConMasViajes(inicio, fin));
    }

}
