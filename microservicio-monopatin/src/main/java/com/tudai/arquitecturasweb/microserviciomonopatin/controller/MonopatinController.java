package com.tudai.arquitecturasweb.microserviciomonopatin.controller;

import com.tudai.arquitecturasweb.microserviciomonopatin.DTO.monopatinDTO;
import com.tudai.arquitecturasweb.microserviciomonopatin.entity.Monopatin;
import com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin;
import com.tudai.arquitecturasweb.microserviciomonopatin.service.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monopatines")
public class MonopatinController {

    @Autowired
    MonopatinService monopatinService;

    @GetMapping
    public List<Monopatin> getAll() {
        return monopatinService.getAll();
    }

    @GetMapping("/{id}")
    public Monopatin getById(@PathVariable("id") int id) {
        return monopatinService.getById(id);
    }

    @PutMapping
    public void create(@RequestBody Monopatin m) {
        monopatinService.save(m);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Monopatin m) {
        monopatinService.update(m, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        monopatinService.deleteById(id);
    }

    /*poner monopatin en mantenimiento*/
    @PostMapping("/{id}")
    public ResponseEntity<Monopatin> enMantenimiento(@PathVariable int id, @RequestBody EstadoMonopatin m) {
        return ResponseEntity.ok(monopatinService.enMantenimiento(m, id));
    }

    @GetMapping("/parada/{idParada}")
    public ResponseEntity<List<monopatinDTO>> getParadas(@PathVariable int idParada) {
        return ResponseEntity.ok(monopatinService.getMonopatinByParada(idParada));
    }

    @GetMapping("/reporte/kilometrosyTiempo")
    public ResponseEntity<List<monopatinDTO>> reporteKilometrosyTiempo(@RequestParam int kilometros, @RequestParam int min) {
        return ResponseEntity.ok(monopatinService.getReporteKilometrosYTiempo(kilometros, min));
    }
}
