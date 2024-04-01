package com.biblioteca.backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    private Long id;
    
    @NotBlank
    private String titulo;

    @NotBlank
    private String autor;

    @NotBlank
    private String categoria;
    
}
