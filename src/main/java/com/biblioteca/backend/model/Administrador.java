package com.biblioteca.backend.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table( name = "Administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {

    @Id
    @NotBlank
    @Column(name = "numero_documento", nullable = false, unique = true)
    private Long numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_Nacimiento")
    private Date fechaNacimiento;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "apellido")
    private String apellido;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 5, max = 15)
    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Size(min = 10, max = 10)
    @Column(name = "numero_contacto")
    private String numeroContacto;

    @NotBlank
    private String direcion;
}
