package com.biblioteca.backend.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
                        joinColumns = @JoinColumn(name = "usuario_id"),
                        inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set <Rol> roles = new HashSet();

    @OneToMany(mappedBy = "Usuario")
    private List <Prestamo> prestamos = new ArrayList<>();

    @OneToMany(mappedBy = "Usuario")
    private List <SolicitudPrestamo> solicitudPrestamos = new ArrayList<>();

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String numeroDocumento;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5, max = 15)
    private String contrasenia;

    @Size(min = 10, max = 10)
    private String numeroContacto;

}
