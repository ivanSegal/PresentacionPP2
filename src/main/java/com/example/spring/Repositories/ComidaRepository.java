package com.example.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.Entities.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
}
