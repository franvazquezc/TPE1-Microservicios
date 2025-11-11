package com.tudai.arquitecturasweb.microserviciopago.service;

import com.tudai.arquitecturasweb.microserviciopago.model.Pago;
import com.tudai.arquitecturasweb.microserviciopago.repository.pagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pagoService {

    @Autowired
    pagoRepository pagoRepository;

    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    public void delete(int id) {
        pagoRepository.deleteById(id);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago getPagoById(int id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void updatePago(int id, Pago pago) {
        Pago p = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("pago no encontrado"));
        p.setDinero(pago.getDinero());
        p.setFecha(pago.getFecha());
        pagoRepository.save(p);
    }

}