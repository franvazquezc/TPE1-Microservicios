package com.tudai.arquitecturasweb.microservicioadmin.feign;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="microservice-usuario", url="http://localhost:8002")
public interface feignUsuario {

    @GetMapping("/Usuarios")
    public List<Usuario> getUsuarios();

    @GetMapping("/Usuario/{id}")
    public Usuario getUsuarioById(@PathVariable long id);

    @GetMapping("/cuenta/{id}")
    public Cuenta getCuentaById(int id);
}
