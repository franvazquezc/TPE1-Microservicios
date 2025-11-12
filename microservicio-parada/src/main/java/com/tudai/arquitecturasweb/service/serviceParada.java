package com.tudai.arquitecturasweb.service;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.ParadaDTO;
import com.tudai.arquitecturasweb.model.Parada;
import com.tudai.arquitecturasweb.repository.repositoryParada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceParada {

    @Autowired
    private repositoryParada repositoryParada;

    public List<Parada> findAll(){
        return repositoryParada.findAll();
    }

    public ParadaDTO findById(Integer id){
        Parada p =  repositoryParada.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el parada "+id));
        ParadaDTO salida = new ParadaDTO();
        salida.setDescripcion(p.getDescripcion());
        salida.setNombre(p.getNombre());
        salida.setLongitud(p.getLongitud());
        salida.setLatitud(p.getLatitud());
        return salida;
    }

    public void delete(int id){
        repositoryParada.deleteById(id);
    }

    public Parada update(Parada parada, int id){
        Parada p = repositoryParada.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontro el parada "+id));
        p.setLatitud(parada.getLatitud());
        p.setLongitud(parada.getLongitud());
        p.setDescripcion(parada.getDescripcion());
        return repositoryParada.save(p);
    }

    public Parada save(Parada parada){
        return repositoryParada.save(parada);
    }
}
