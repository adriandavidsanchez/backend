package com.biblioteca.backend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Solicitudes_Prestamos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "SolicitudPrestamo")
    private Libro libro;

    @Temporal(TemporalType.DATE)
    private String solicitudPrestamoLibro;

    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudPrestamo;
}
