package com.tudai.arquitecturasweb.microserviciousuario.foreign;

import com.tudai.arquitecturasweb.microserviciopago.model.Pago;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservice-pago", url="http://localhost:8002/pago")
public interface foreignPago {

    @PostMapping
    Pago save(@RequestBody Pago pago);

}
