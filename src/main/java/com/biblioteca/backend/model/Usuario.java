package com.biblioteca.backend.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @NotBlank
    @Column(name = "numero_Documento", nullable = false, unique = true)
    private Long numeroDocumento;

    @ManyToOne
    @JoinColumn(name = "rol_Id")
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "usuario_Id")
    private Administrador administrador;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @NotBlank
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 5, max = 15)
    @Column(name = "contrania", nullable = false)
    private String contrasenia;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(name = "contacto", nullable = false)
    private String numeroContacto;

    @NotBlank
    private String direccion;
}
