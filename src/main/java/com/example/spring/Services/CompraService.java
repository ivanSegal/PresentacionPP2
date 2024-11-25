package com.example.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.Entities.Comida;
import com.example.spring.Entities.Compra;
import com.example.spring.Entities.DetalleCompra;
import com.example.spring.Repositories.ComidaRepository;
import com.example.spring.Repositories.CompraRepository;
import com.example.spring.Repositories.DetalleCompraRepository;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;
//funciona
 /*
    public Compra guardarCompra(Compra compra) {
        
         for (DetalleCompra detalle : compra.getDetalles()) {
            detalle.setCompra(compra);
        }
        return compraRepository.save(compra);
    }
*/
    ///////nuevo

    @Autowired
    private ComidaRepository comidaRepository; // Necesario para buscar Comida por ID

    public Compra guardarCompra(Compra compra) {
        // Primero, guarda la compra para obtener el ID
        Compra nuevaCompra = compraRepository.save(compra);

        // Luego, maneja los detalles de la compra
        for (DetalleCompra detalle : nuevaCompra.getDetalles()) {
            detalle.setCompra(nuevaCompra);

            // Buscar la comida por ID y asociarla con DetalleCompra
            Comida comida = comidaRepository.findById(detalle.getComida().getId())
                    .orElseThrow(() -> new RuntimeException("Comida no encontrada"));
            detalle.setComida(comida);

            detalleCompraRepository.save(detalle);
        }
		
        return nuevaCompra;
    }
    
    ///////
    public List<Compra> obtenerComprasPorCliente(Long clienteId) {
    return compraRepository.findByClienteId(clienteId);
}

}
