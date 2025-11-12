package com.tudai.arquitecturasweb.microservicioviaje.foreign;

import com.tudai.arquitecturasweb.microserviciocommons.dtos.MonopatinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="microservice-monopatin", url="http://localhost:8002")
public interface foreignMonopatin {

    @GetMapping("/monopatin/{id}")
    MonopatinDTO getById(@PathVariable int id);

}
