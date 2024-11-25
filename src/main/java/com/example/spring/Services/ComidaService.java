package com.example.spring.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.Entities.Comida;
import com.example.spring.Repositories.ComidaRepository;

import java.util.List;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    public List<Comida> getAllComidas() {
        return comidaRepository.findAll();
    }

    public Comida saveComida(Comida comida) {
        return comidaRepository.save(comida);
    }

    public void deleteComida(Long id) {
        comidaRepository.deleteById(id);
    }
}

