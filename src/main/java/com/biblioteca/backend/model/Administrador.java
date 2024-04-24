package com.biblioteca.backend.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table( name = "Administrador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "administrador_roles",
                        joinColumns = @JoinColumn(name = "admisnistrador_id"),
                        inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set <Rol> roles = new  HashSet<>();

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "apellido")
    private String apellido;

    @NotBlank
    @Column(name = "numero_documento")
    private String numeroDocumento;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 5, max = 15)
    @Column(name = "contrasenia")
    private String contrasenia;

    @Size(min = 10, max = 10)
    @Column(name = "numero_contacto")
    private String numeroContacto;
}
