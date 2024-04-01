package com.biblioteca.backend.Services;

import com.biblioteca.backend.entities.Libro;
import java.util.List;

public interface LibroService {

    List<Libro> obtenerTodosLibros();

    Libro obtenerPorId(Long id);

    Libro ingresarLibroNuevo(Libro libro);

    Libro actualizarLibro(Long id,Libro libro);

    void eliminarLibro(Long id);

    Long contarLibros();
}
    