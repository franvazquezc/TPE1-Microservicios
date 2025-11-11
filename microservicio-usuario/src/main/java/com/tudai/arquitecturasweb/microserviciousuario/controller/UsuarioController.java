package com.tudai.arquitecturasweb.microserviciousuario.controller;

import com.tudai.arquitecturasweb.microserviciousuario.model.Usuario;
import com.tudai.arquitecturasweb.microserviciousuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/Usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getAll();
    }

    @GetMapping("/Usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        return usuarioService.getById(id);
    }

    @PostMapping("/Usuario")
    public void saveUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

    @DeleteMapping("/Usuario/{id}")
    public void deleteUsuario(@PathVariable int id){
        usuarioService.delete(id);
    }

    @PutMapping("/Usuario/{id}")
    public void updateUsuario(@RequestBody Usuario usuario, @PathVariable int id){
        usuarioService.update(id, usuario);
    }
}
