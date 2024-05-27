package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
import com.biblioteca.backend.Services.LibroService;
import com.biblioteca.backend.model.Libro;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    //La clase Model se utiliza para transferir objetos del controller a la vista o HTML
    @GetMapping
    public String listarLibros(Model model){
        List<Libro> libros = libroService.obtenerTodosLibros();
        model.addAttribute("listaDelibros", libros);
        return "lista";
    }

    @PutMapping("/{id}")
    public Libro putMethodName(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        
        if (libroActualizado == null) {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
            return libroService.actualizarLibro(id, libroActualizado);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro (@PathVariable Long id){

        libroService.eliminarLibro(id);
        return "Libro eliminado";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "nuevoLibro";
    }

    @PostMapping("/nuevo")
    public String ingresarLibroNuevo(Libro libro, Model model) {
        libroService.ingresarLibroNuevo(libro);
        return "redirect:/libros";
    }

    @GetMapping("/{id}")
    public Libro obtenerPorIdLibro (@PathVariable Long id) {

        return libroService.obtenerPorId(id);
    }

    @GetMapping("/contarlibros")
    public long contarLibros(){

        return libroService.contarLibros();
    }

    @GetMapping("/buscarlibro")
    public List<Libro> buscarLibro (@RequestParam String criterio){

        return libroService.buscarLibro(criterio);
    }

    @GetMapping("/{id}/disponible")
    public boolean estaDisponible(@PathVariable Long id) {
        return libroService.estaDisponible(id);
    }
    
}
