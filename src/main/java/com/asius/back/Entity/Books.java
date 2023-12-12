package com.asius.back.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBooks;
    private String nombre;


    private String descripcion;

    @Column(length = 1000)
    private String sinopsis;

    private String img;
    private String autor;
    private String editorial;
    private String publicacion;
    private Integer paginas;
    private String formato;
    private String isbn;
    private String genero;
    private String documento;
    private String idioma;
    private String costo;
    private String estado;


    public Books(){

    }
}
