package com.example.spring.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.spring.Entities.Comida;
import com.example.spring.Services.ComidaService;

import java.util.List;

@RestController
@RequestMapping("/api/comidas")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping
    public List<Comida> getAllComidas() {
        return comidaService.getAllComidas();
    }

    @PostMapping
    public Comida createComida(@RequestBody Comida comida) {
        return comidaService.saveComida(comida);
    }

    @DeleteMapping("/{id}")
    public void deleteComida(@PathVariable Long id) {
        comidaService.deleteComida(id);
    }
}
