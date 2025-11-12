package com.tudai.arquitecturasweb.microserviciomonopatin.service;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.ParadaDTO;
import com.tudai.arquitecturasweb.microserviciomonopatin.DTO.monopatinDTO;
import com.tudai.arquitecturasweb.microserviciomonopatin.entity.Monopatin;
import com.tudai.arquitecturasweb.microserviciomonopatin.foreign.foreignParada;
import com.tudai.arquitecturasweb.microserviciomonopatin.model.EstadoMonopatin;
import com.tudai.arquitecturasweb.microserviciomonopatin.repository.MonopatinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MonopatinService {

    @Autowired
    private MonopatinRepository monopatinRepository;
    @Autowired
    private foreignParada foreignParada;

    public List<Monopatin> getAll() {
        return monopatinRepository.findAll();
    }

    public Monopatin getById(int id) {
        return monopatinRepository.findById(id).orElse(null);
    }

    public Monopatin save(Monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    public void update(Monopatin nuevo, int id) {
        Monopatin m = monopatinRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));

        m.setActivo(nuevo.isActivo());
        m.setEstado(nuevo.getEstado());
        m.setLatitud(nuevo.getLatitud());
        m.setLongitud(nuevo.getLongitud());
        m.setKmRecorridos(nuevo.getKmRecorridos());
        m.setMinutosDeUso(nuevo.getMinutosDeUso());
        m.setIdParadaActual(nuevo.getIdParadaActual());
        m.setIdViajeActual(nuevo.getIdViajeActual());

        monopatinRepository.save(m);
    }

    public void deleteById(int id) {
        monopatinRepository.deleteById(id);
    }

    public Monopatin enMantenimiento(EstadoMonopatin estado, int id){
        Monopatin m = this.getById(id);
        m.setEstado(estado);
        return monopatinRepository.save(m);
    }

    public List<monopatinDTO> getMonopatinByParada(int idParada){
        ParadaDTO paradaDTO = foreignParada.getParadaById(idParada);
        if(paradaDTO != null){
            /*Convierte el resultado a dto automaticamente*/
            return monopatinRepository.findByIdParadaActual(idParada).stream()
                    .map(this::convertir)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public monopatinDTO convertir(Monopatin monopatin){
        Monopatin m = monopatinRepository.findById(monopatin.getId()).orElse(null);
        monopatinDTO monopatinDTO = new monopatinDTO();
        monopatinDTO.setEstado(m.getEstado());
        monopatinDTO.setLatitud(m.getLatitud());
        monopatinDTO.setLongitud(m.getLongitud());
        monopatinDTO.setActivo(m.isActivo());
        return monopatinDTO;
    }

    public List<monopatinDTO> getReporteKilometrosYTiempo(int kilometros, int tiempo){
        List<monopatinDTO> lista = monopatinRepository.reporteMonopatinKilometrosYTiempo(kilometros, tiempo);
        return lista;
    }
}
