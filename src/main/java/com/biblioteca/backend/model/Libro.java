package com.biblioteca.backend.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "Libro")
    private List<Prestamo> prestamos = new ArrayList<>();

    @OneToMany(mappedBy = "Libro")
    private List<SolicitudPrestamo> solicitudPrestamos = new ArrayList<>();

    @NotBlank
    @Column(name = "titulo")
    private String titulo;

    @NotBlank
    @Column(name = "autor")
    private String autor;

    @NotBlank
    @Column(name = "categoria")
    private String categoria;

    // private boolean disponibilidadLibro;

}
