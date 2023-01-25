package com.kn.demo;


import com.kn.demo.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

interface PersonClient {

    @GetExchange("/persons")
    Flux<Person> all();

    @GetExchange("/persons/{name}")
    Flux<Person> byName(@PathVariable String name);
}


