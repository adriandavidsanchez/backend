package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.backend.Services.PrestamoService;
import com.biblioteca.backend.model.Libro;
import com.biblioteca.backend.model.Prestamo;
import com.biblioteca.backend.model.Usuario;

import repository.LibroRepository;
import repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoControlller {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/crear")
    public Prestamo crearPrestamo(@RequestParam Long usuarioId, @RequestParam Long libroId) {
        return prestamoService.crearPrestamo(usuarioId, libroId);
    }

    @GetMapping
    public List<Prestamo> obtenerTodosLosPrestamos() {

        return prestamoService.obtenerListaPrestamos();
    }

    @GetMapping("/{id}")
    public Prestamo obtenerPrestamoPorId(@PathVariable Long id) {

        return prestamoService.obtenerPrestamosPorId(id);
    }

    @PostMapping("/solicitar")
    public void solicitarPrestamo(@RequestParam Long usuarioId, @RequestParam Long libroId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Libro libro = libroRepository.findById(libroId).orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        prestamoService.solitarPrestamo(usuario, libro);
    }

    @PutMapping("/{id}/finalizar")
    public Prestamo finalizarPrestamo(@PathVariable Long id) {
        return prestamoService.finalizarPrestamo(id);
    }
}
