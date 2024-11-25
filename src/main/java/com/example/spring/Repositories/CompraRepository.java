package com.example.spring.Repositories;



import com.example.spring.Entities.Compra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
	List<Compra> findByClienteId(Long clienteId);
}

