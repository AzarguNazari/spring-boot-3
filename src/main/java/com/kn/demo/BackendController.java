package com.kn.demo;

import com.kn.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BackendController {
    private final Map<String, Person> personMap = new HashMap<>();
    {
        personMap.put("Hazar", new Person("Hazar", 31, "London"));
        personMap.put("Yousuf", new Person("Yousuf", 35, "Hamburg"));
        personMap.put("Josh", new Person("Josh", 34, "Paris"));
    }
    @GetMapping("/persons/{name}")
    public Person personByName(@PathVariable String name) {
        return personMap.get(name);
    }
    @GetMapping("/persons")
    public List<Person> persons() {
        return new ArrayList<>(personMap.values());
    }
}

