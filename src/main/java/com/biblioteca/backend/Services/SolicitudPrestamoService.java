package com.biblioteca.backend.Services;

import com.biblioteca.backend.model.SolicitudPrestamo;
import java.util.List;

public interface SolicitudPrestamoService {
    
    SolicitudPrestamo solicitarPrestamo (SolicitudPrestamo solicitud);

    SolicitudPrestamo aprobarPrestamo (Long id);

    SolicitudPrestamo rechazarPrestamo (Long id);

    SolicitudPrestamo devolverLibro (Long id);

    SolicitudPrestamo obtenerPorId (Long id);

    void eliminarSolicitudPrestamo (Long id);

    List <SolicitudPrestamo> obternerSolicitudesPrestamo ();


}
