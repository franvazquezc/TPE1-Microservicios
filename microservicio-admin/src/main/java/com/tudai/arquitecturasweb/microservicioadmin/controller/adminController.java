package com.tudai.arquitecturasweb.microservicioadmin.controller;

import com.tudai.arquitecturasweb.microservicioadmin.service.adminService;
import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.service.cuentaService;
import com.tudai.arquitecturasweb.microserviciousuario.Usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok(adminService.getAllUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public  ResponseEntity<Usuario> getUsuarioById(@PathVariable int id){
        return ResponseEntity.ok(adminService.getUsuarioById(id));
    }

    @GetMapping("/cuenta/{id}")
    public ResponseEntity<Cuenta> getCuentaById2(@PathVariable int id){
        return ResponseEntity.ok(adminService.getCuentaById(id));
    }

}
