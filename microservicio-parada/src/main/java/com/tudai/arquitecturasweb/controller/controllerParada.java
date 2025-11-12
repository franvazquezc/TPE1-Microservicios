package com.tudai.arquitecturasweb.controller;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.ParadaDTO;
import com.tudai.arquitecturasweb.model.Parada;
import com.tudai.arquitecturasweb.service.serviceParada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parada")
public class controllerParada {

    @Autowired
    private serviceParada serviceParada;

    @GetMapping("")
    public ResponseEntity<List<Parada>> getAllParadas(){
        return ResponseEntity.ok(serviceParada.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParadaDTO> getParadaById(@PathVariable int id){
        return ResponseEntity.ok(serviceParada.findById(id));
    }

    @DeleteMapping("/{id}")
    public void  deleteParadaById(@PathVariable int id){
        serviceParada.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parada> updateParada(@PathVariable int id, @RequestBody Parada parada){
        return ResponseEntity.ok(serviceParada.update(parada, id));
    }

    @PostMapping("")
    public ResponseEntity<Parada> addParada(@RequestBody Parada parada){
        return ResponseEntity.ok(serviceParada.save(parada));
    }

}
