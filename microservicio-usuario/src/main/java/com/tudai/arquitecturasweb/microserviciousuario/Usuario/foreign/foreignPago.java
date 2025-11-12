package com.tudai.arquitecturasweb.microserviciousuario.Usuario.foreign;

import com.tudai.arquitecturasweb.microserviciousuario.Cuenta.model.Cuenta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservice-pago", url="http://localhost:8002")
public interface foreignPago {

    @PostMapping
    Cuenta save(@RequestBody Cuenta cuenta);

}
