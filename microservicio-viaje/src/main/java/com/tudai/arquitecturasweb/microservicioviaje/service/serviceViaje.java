package com.tudai.arquitecturasweb.microservicioviaje.service;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.MonopatinDTO;
import com.tudai.arquitecturasweb.microservicioviaje.foreign.foreignMonopatin;
import com.tudai.arquitecturasweb.microservicioviaje.model.Viaje;
import com.tudai.arquitecturasweb.microservicioviaje.repository.repositoryViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceViaje {

    @Autowired
    repositoryViaje repositoryViaje;
    @Autowired
    foreignMonopatin foreignMonopatin;

    public List<Viaje> findAll() {
        return repositoryViaje.findAll();
    }

    public Viaje findById(Integer id) {
        return repositoryViaje.findById(id).orElseThrow(() -> new RuntimeException("No existe el viaje con el id: " + id));
    }

    public Viaje save(Viaje viaje) {
        return repositoryViaje.save(viaje);
    }

    public void delete(int id) {
        repositoryViaje.deleteById(id);
    }

    public void update(int id, Viaje viaje){
        Viaje v = this.findById(id);
        v.setDestinoId(viaje.getDestinoId());
        v.setOrigenId(viaje.getOrigenId());
        v.setHoraFin(viaje.getHoraFin());
        v.setHoraInicio(viaje.getHoraInicio());
        v.setMonopatinId(viaje.getMonopatinId());
        v.setKilometros(viaje.getKilometros());
        v.setFecha(viaje.getFecha());
        repositoryViaje.save(v);
    }

    public List<MonopatinDTO> getMonopatinesViajeXAño(int viajes, int anio){
        List<MonopatinDTO> monopatinDTO = new ArrayList<>();
        List<Integer> monopatines = repositoryViaje.viajesXMonopatin(viajes, anio);
        for (Integer monopatin : monopatines) {
            MonopatinDTO m = foreignMonopatin.getById(monopatin);
            if(m == null){return null;}
            monopatinDTO.add(m);
        }
        return monopatinDTO;
    }

}
