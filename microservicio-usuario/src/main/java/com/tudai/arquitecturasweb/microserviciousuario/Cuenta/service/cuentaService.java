package com.tudai.arquitecturasweb.microserviciousuario.Cuenta.service;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.repository.cuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cuentaService {

    @Autowired
    cuentaRepository cuentaRepository;

    public List<Cuenta> getAll() {
        return cuentaRepository.findAll();
    }

    public void delete(int id) {
        cuentaRepository.deleteById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta getCuentaById(int id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    public void anularCuenta(int id){
        Cuenta cuenta = this.getCuentaById(id);
        cuenta.setActiva(false);
        cuentaRepository.save(cuenta);
    }

}