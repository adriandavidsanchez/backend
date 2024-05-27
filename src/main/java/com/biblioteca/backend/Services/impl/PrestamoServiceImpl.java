package com.biblioteca.backend.Services.impl;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.PrestamoService;
import repository.LibroRepository;
import repository.PrestamoRepository;
import repository.UsuarioRepository;
import com.biblioteca.backend.model.*;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /*  @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamo) {
        
        return null;
    }*/

    @Override
    public Long contarPrestamos() {
        return prestamoRepository.count();
    }

    /*  @Override
    public Prestamo ingresarPrestamoNuevo(Prestamo prestamo) {
        
        return null;
    }*/

    @Override
    public List<Prestamo> obtenerListaPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public void solitarPrestamo(Usuario usuario, Libro libro) {
        
        Date fechaActual = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaActual);
        cal.add(Calendar.DATE, 7); // Agregar 7 días a la fecha actual
        Date fechaDevolucion = cal.getTime();
        Prestamo prestamo = new Prestamo(libro, usuario, fechaActual, fechaDevolucion, "Pendiente");
        prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo crearPrestamo(Long usuarioId, Long libroId) {
        
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(libroId).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if (!libro.isDisponibilidadLibro()) {
            throw new RuntimeException("El libro no está disponible para préstamo");
        }

        libro.setDisponibilidadLibro(false);
        libroRepository.save(libro);

        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);
        prestamo.setEstado("ACTIVO");

        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo obtenerPrestamosPorId(Long id) {

        return prestamoRepository.findById(id).orElseThrow(()-> new RuntimeException("Préstamo no encontrado"));
    }

    @Override
    public Prestamo finalizarPrestamo(Long id) {

        Prestamo prestamo = prestamoRepository.findById(id).orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        if ("FINALIZADO".equals(prestamo.getEstado())) {
            throw new RuntimeException("El préstamo ya ha sido finalizado");
        }

        Libro libro = prestamo.getLibro();
        libro.setDisponibilidadLibro(true);
        libroRepository.save(libro);

        prestamo.setEstado("FINALIZADO");
        return prestamoRepository.save(prestamo);
    }

}
