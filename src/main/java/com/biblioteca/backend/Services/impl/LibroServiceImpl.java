package com.biblioteca.backend.Services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.LibroService;
import com.biblioteca.backend.model.Libro;
import java.util.ArrayList;
import repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        Libro libroBBDD = libroRepository.findById(id).orElse(null);
        if(libroBBDD != null){
            libroBBDD.setTitulo(libro.getTitulo());
            libroBBDD.setAutor(libro.getAutor());
            libroBBDD.setCategoria(libro.getCategoria());
            return libroRepository.save(libroBBDD);
        }
        return null;
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Libro ingresarLibroNuevo(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro obtenerPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> obtenerTodosLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Long contarLibros() {
        return libroRepository.count();
    }

    @Override
    public List<Libro> buscarLibro(String criterio){
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : obtenerTodosLibros()) {
            if (libro.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(criterio.toLowerCase()) ||
                    libro.getCategoria().toLowerCase().contains(criterio.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    @Override
    public boolean estaDisponible(Long id) {
        
        return false;
    }

    
    
}
