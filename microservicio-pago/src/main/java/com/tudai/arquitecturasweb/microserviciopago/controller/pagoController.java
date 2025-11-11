package com.tudai.arquitecturasweb.microserviciopago.controller;

import com.tudai.arquitecturasweb.microserviciopago.model.Pago;
import com.tudai.arquitecturasweb.microserviciopago.service.pagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class pagoController {

    @Autowired
    pagoService pagoService;

    @GetMapping("/")
    public List<Pago> getPagos(){
        return pagoService.getAll();
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable int id){
        return pagoService.getPagoById(id);
    }

    @PostMapping("")
    public Pago createPago(@RequestBody Pago pago){
        return pagoService.save(pago);
    }

    @PostMapping("/pago/{id}")
    public void update(@RequestBody Pago pago, @PathVariable int id){
        pagoService.updatePago(id,pago);
    }

    @DeleteMapping("/pago/{id}")
    public void deletePago(@PathVariable int id){
        pagoService.delete(id);
    }
}