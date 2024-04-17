package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
import com.biblioteca.backend.Services.LibroService;
import com.biblioteca.backend.model.Libro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/libros")
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

    
}
