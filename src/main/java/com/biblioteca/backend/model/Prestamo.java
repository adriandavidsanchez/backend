package com.biblioteca.backend.model;

import java.util.Date;
import jakarta.persistence.Column;
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
@Table(name = "Prestamos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prestamo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_Id")
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(name = "libro_Id")
        private Libro libro;

        @Temporal(TemporalType.DATE)
        @Column(name = "fecha_Prestamo")
        private Date fechaPrestamo;

        @Temporal(TemporalType.DATE)
        @Column(name = "fecha_Devolucion")
        private Date fechaDevolucion;

        @Column(name = "estado")
        private String estado;

        public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion, String estado) {
                this.libro = libro;
                this.usuario = usuario;
                this.fechaPrestamo = fechaPrestamo;
                this.fechaDevolucion = fechaDevolucion;
                this.estado = estado;
        }
        
}
