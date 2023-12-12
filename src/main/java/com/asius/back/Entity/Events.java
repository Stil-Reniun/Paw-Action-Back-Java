package com.asius.back.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "eventos")
@Data
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvents;
    private String img;
    private String nombre;
    private String tipo;
    private String descripcion;
    private String invitado;
    private String departamento;
    private String lugar;
    private String fecha;

    public Events(){}
}
