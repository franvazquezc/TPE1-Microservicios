package com.tudai.arquitecturasweb.microservicioviaje.foreign;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.UsuariosConMasViajesDTO;
import jakarta.persistence.ForeignKey;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name="microservice-usuario", url="http://localhost:8002")
public interface foreignUsuario {

    @PutMapping("/usuario/filtrarCuenta")
    List<UsuariosConMasViajesDTO> filtrarUsuarios(boolean premiun);

}
