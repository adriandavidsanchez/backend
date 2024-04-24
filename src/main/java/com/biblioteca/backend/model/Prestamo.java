package com.biblioteca.backend.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

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
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(name = "libro_id")
        private Libro libro;

        @OneToMany(mappedBy = "Prestamo]")
        private List <SolicitudPrestamo> solicitudPrestamoLibro = new ArrayList<>();

        @Temporal(TemporalType.DATE)
        @Column(name = "fecha_prestamo")
        private Date fechaPrestamo;

        @Temporal(TemporalType.DATE)
        @Column(name = "fecha_devolucion")
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
