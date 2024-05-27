package com.biblioteca.backend.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.SolicitudPrestamoService;
import com.biblioteca.backend.model.Libro;
import com.biblioteca.backend.model.SolicitudPrestamo;
import repository.LibroRepository;
import repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService {

    @Autowired
    private SolicitudPrestamoRepository solicitudPrestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public SolicitudPrestamo aprobarPrestamo(Long id) {

        SolicitudPrestamo solicitud = solicitudPrestamoRepository.findById(id).orElse(null);
        if (solicitud == null || !"PENDIENTE".equals(solicitud.getEstado())) {
            throw new RuntimeException("La solicitud no es válida o ya ha sido procesada.");
        }
        Libro libro = solicitud.getLibro();
        libro.setDisponibilidadLibro(false);
        libroRepository.save(libro);
        solicitud.setEstado("APROBADO");
        return solicitudPrestamoRepository.save(solicitud);
    }

    @Override
    public SolicitudPrestamo devolverLibro(Long id) {
        SolicitudPrestamo solicitud = solicitudPrestamoRepository.findById(id).orElse(null);
        if (solicitud == null || !"APROBADO".equals(solicitud.getEstado())) {
            throw new RuntimeException("La solicitud no es válida o el libro no está prestado.");
        }
        Libro libro = solicitud.getLibro();
        libro.setDisponibilidadLibro(true);
        libroRepository.save(libro);
        solicitud.setEstado("DEVUELTO");
        return solicitudPrestamoRepository.save(solicitud);
    }

    @Override
    public void eliminarSolicitudPrestamo(Long id) {
        
        solicitudPrestamoRepository.deleteById(id);
    }

    @Override
    public SolicitudPrestamo obtenerPorId(Long id) {
        
        return solicitudPrestamoRepository.findById(id).orElse(null);
    }

    @Override
    public List<SolicitudPrestamo> obternerSolicitudesPrestamo() {
        
        return solicitudPrestamoRepository.findAll();
    }

    @Override
    public SolicitudPrestamo rechazarPrestamo(Long id) {
        SolicitudPrestamo solicitud = solicitudPrestamoRepository.findById(id).orElse(null);
        if (solicitud == null || !"PENDIENTE".equals(solicitud.getEstado())) {
            throw new RuntimeException("La solicitud no es válida o ya ha sido procesada.");
        }
        solicitud.setEstado("RECHAZADO");
        return solicitudPrestamoRepository.save(solicitud);
    }

    @Override
    public SolicitudPrestamo solicitarPrestamo(SolicitudPrestamo solicitud) {
        Libro libro = libroRepository.findById(solicitud.getLibro().getId()).orElse(null);
        if (libro == null || !libro.isDisponibilidadLibro()) {
            throw new RuntimeException("El libro no está disponible para préstamo.");
        }
        solicitud.setEstado("PENDIENTE");
        return solicitudPrestamoRepository.save(solicitud);
    }

    

}
