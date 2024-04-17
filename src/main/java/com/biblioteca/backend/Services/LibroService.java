package com.biblioteca.backend.Services;

import java.util.List;
import com.biblioteca.backend.model.Libro;

public interface LibroService {

    List<Libro> obtenerTodosLibros();

    Libro obtenerPorId(Long id);

    Libro ingresarLibroNuevo(Libro libro);

    Libro actualizarLibro(Long id,Libro libro);

    void eliminarLibro(Long id);

    Long contarLibros();

    List<Libro> buscarLibro (String criterio);

    boolean estaDisponible(Long id);
}
    