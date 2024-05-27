package com.biblioteca.backend.Services;

import java.util.List;
import com.biblioteca.backend.model.*;

public interface PrestamoService {

    List<Prestamo> obtenerListaPrestamos();

    //Prestamo ingresarPrestamoNuevo(Prestamo prestamo);

    // Prestamo actualizarPrestamo (Long id, Prestamo prestamo);

    Prestamo obtenerPrestamosPorId (Long id);

    Long contarPrestamos ();

    void solitarPrestamo (Usuario usuario, Libro libro);

    //

    Prestamo crearPrestamo (Long usuarioId, Long libroId);

    Prestamo finalizarPrestamo (Long id);


}
