package com.tudai.arquitecturasweb.service;

import com.tudai.arquitecturasweb.DTO.FacturaDTO;
import com.tudai.arquitecturasweb.DTO.TarifaDTO;
import com.tudai.arquitecturasweb.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tudai.arquitecturasweb.repository.repositoryTarifa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class serviceTarifa {

    @Autowired
    repositoryTarifa repositoryTarifa;

    public List<Tarifa> getAll(){
        return repositoryTarifa.findAll();
    }

    public Tarifa getById(int id){
        return repositoryTarifa.findById(id).orElseThrow(()->new RuntimeException("Tarifa no encontrado"));
    }

    public void delete(int id){
        repositoryTarifa.deleteById(id);
    }

    public Tarifa save(Tarifa tarifa){
        return repositoryTarifa.save(tarifa);
    }

    public Tarifa update(Tarifa tarifa, int id){
        Tarifa t =  this.getById(id);
        t.setExtraPorPausa(tarifa.getExtraPorPausa());
        t.setFechaTarifa(tarifa.getFechaTarifa());
        t.setPrecioPorMinuto(tarifa.getPrecioPorMinuto());
        t.setPrecioPorKilometro(tarifa.getPrecioPorKilometro());
        return repositoryTarifa.save(t);
    }

    public TarifaDTO editarExtraPorPausa(int extra, int id){
        Tarifa t =  this.getById(id);
        t.setExtraPorPausa(extra);
        repositoryTarifa.save(t);
        TarifaDTO tarifaDTO = new TarifaDTO();
        tarifaDTO.setExtraPorPausa(extra);
        tarifaDTO.setPrecioPorKilometro(t.getPrecioPorKilometro());
        tarifaDTO.setPrecioPorMinuto(t.getPrecioPorMinuto());
        return tarifaDTO;
    }

    public FacturaDTO obtenerFactura(int mesInicio, int mesFin, int anio){
        FacturaDTO factura = repositoryTarifa.obtenerTotalFacturado(mesInicio, mesFin, anio);
        return factura;
    }

    public Tarifa actualizarPrecio(LocalDate actualizo){
        //LocalDate fechaActual = LocalDate.now();
        return repositoryTarifa.encontrarTarifaPorCorte(actualizo).orElseThrow(()->new RuntimeException("Tarifa no encontrado"));
    }
}
