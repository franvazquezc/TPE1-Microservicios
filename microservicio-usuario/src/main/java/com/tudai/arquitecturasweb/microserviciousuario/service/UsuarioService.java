package com.tudai.arquitecturasweb.microserviciousuario.service;

import com.tudai.arquitecturasweb.microserviciousuario.model.Usuario;
import com.tudai.arquitecturasweb.microserviciousuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario getById(int id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        return usuario;
    }

    public void update(int id,Usuario usuario){
        Usuario user = this.getById(id);
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setAlias(usuario.getAlias());
        user.setCelular(usuario.getCelular());
    }

    public Usuario save(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    public void delete(int id){
        usuarioRepository.deleteById(id);
    }

}
