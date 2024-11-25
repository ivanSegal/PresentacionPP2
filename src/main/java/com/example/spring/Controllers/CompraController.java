package com.example.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.Entities.Compra;
import com.example.spring.Services.CompraService;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Compra> realizarCompra(@RequestBody Compra compra) {
        Compra nuevaCompra = compraService.guardarCompra(compra);
        return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List> obtenerComprasPorCliente(@PathVariable Long clienteId) {
    List compras = compraService.obtenerComprasPorCliente(clienteId);
    return new ResponseEntity<>(compras, HttpStatus.OK);
    }



}
