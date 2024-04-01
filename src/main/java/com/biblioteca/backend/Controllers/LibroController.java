package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import com.biblioteca.backend.Services.LibroService;
import com.biblioteca.backend.entities.Libro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/Libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    //La clase Model se utiliza para transferir objetos del controller a la vista o HTML
    @GetMapping
    public String listarLibros(Model model){
        List<Libro> libros = libroService.obtenerTodosLibros();
        model.addAttribute("ListaDelibros", libros);
        return "Lista";
    }
}
