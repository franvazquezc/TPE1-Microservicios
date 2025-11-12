package com.tudai.arquitecturasweb.microserviciomonopatin.foreign;
import com.tudai.arquitecturasweb.microserviciocommons.dtos.ParadaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*Seleccionar el puerto correcto...*/
@FeignClient(name="microservice-parada", url="http://localhost:8002")
public interface foreignParada {

    @GetMapping("/parada/{id}")
    public ParadaDTO getParadaById(@PathVariable int id);

}
