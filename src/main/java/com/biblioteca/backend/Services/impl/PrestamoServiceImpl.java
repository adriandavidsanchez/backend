package com.biblioteca.backend.Services.impl;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.PrestamoService;
import repository.PrestamoRepository;
import com.biblioteca.backend.model.*;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Long contarPrestamos() {
        return prestamoRepository.count();
    }

    @Override
    public Prestamo ingresarPrestamoNuevo(Prestamo prestamo) {
        // TODO Auto-generated method stub
        return null;
    }

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

    
}
