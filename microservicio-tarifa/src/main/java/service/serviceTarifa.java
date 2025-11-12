package service;

import DTO.TarifaDTO;
import model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.repositoryTarifa;

import java.util.List;

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
        t.setInicioVigencia(tarifa.getInicioVigencia());
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
}
