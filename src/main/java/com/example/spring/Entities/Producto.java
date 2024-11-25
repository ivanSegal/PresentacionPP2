package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idProducto;

    @Column(name = "idcliente")
    private Long idCliente;

    @Column(name = "idcarrito")
    private Long idCarrito;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "precio")
    private String precio;
    
    @OneToMany(mappedBy="producto", cascade = CascadeType.PERSIST)
    private List<DetallePedido> detalle = new ArrayList<DetallePedido>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
    		name="producto_categoria",
    		joinColumns= @JoinColumn(name= "producto_id"),
    		inverseJoinColumns = @JoinColumn(name= "categoria_id"))
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @Column(name = "subtotal")
    private String subtotal;

}
