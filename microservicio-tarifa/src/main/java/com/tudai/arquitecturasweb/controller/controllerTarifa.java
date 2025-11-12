package com.tudai.arquitecturasweb.controller;


import com.tudai.arquitecturasweb.DTO.FacturaDTO;
import com.tudai.arquitecturasweb.DTO.TarifaDTO;
import com.tudai.arquitecturasweb.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tudai.arquitecturasweb.service.serviceTarifa;

import java.util.List;

@RestController
@RequestMapping("/tarifa")
public class controllerTarifa {

    @Autowired
    serviceTarifa serviceTarifa;

    @GetMapping("")
    public ResponseEntity<List<Tarifa>> getAll() {
        return ResponseEntity.ok(serviceTarifa.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarifa> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(serviceTarifa.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        serviceTarifa.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Tarifa> addTarifa(@RequestBody Tarifa tarifa) {
        return ResponseEntity.ok(serviceTarifa.save(tarifa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarifa>  updateTarifa(@PathVariable Integer id, @RequestBody Tarifa tarifa) {
        return ResponseEntity.ok(serviceTarifa.update(tarifa, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarifaDTO> editarExtraPorPausa(@PathVariable Integer id, @RequestParam int extra) {
        return ResponseEntity.ok(serviceTarifa.editarExtraPorPausa(id, extra));
    }

    @GetMapping("/factura")
    public ResponseEntity<FacturaDTO> getFactura(@RequestParam("mesInicio") int mesInicio, @RequestParam("mesFin") int mesFin, @RequestParam int anio) {
        return ResponseEntity.ok(serviceTarifa.obtenerFactura(mesInicio, mesFin, anio));
    }
}
