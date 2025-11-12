package com.tudai.arquitecturasweb.microservicioadmin.service;

import com.tudai.arquitecturasweb.microservicioadmin.feign.feignUsuario;
import com.tudai.arquitecturasweb.microservicioadmin.repository.adminRepository;
import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminService {

    @Autowired
    private adminRepository adminRepository;
    @Autowired
    private feignUsuario feignUsuario;

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = feignUsuario.getUsuarios();
        return usuarios;
    }

    public Usuario getUsuarioById(int id) {
        return feignUsuario.getUsuarioById(id);
    }

    public Cuenta getCuentaById(int id) {
        return feignUsuario.getCuentaById(id);
    }
}
