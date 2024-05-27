package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.backend.Services.AdministradorService;
import com.biblioteca.backend.model.Administrador;


import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/crear")
    public String mostrarFormulariAdministrador(Model model){
        model.addAttribute("admisnistrador", new Administrador());
        return "formulario-admisnistrador";
    }

    @PostMapping
    public String crearAdministrador (@ModelAttribute Administrador administrador, Model model){
        try{
            administradorService.crearAdministrador(administrador);
            return "redirect:/administrador";
        }catch (Exception e) {
            model.addAttribute("error", "Hubo un error al crear el usuario");
            return "formulario-administrador";
        }
    }

    @PutMapping("/{id}")
    public Administrador actualizarAdministrador (@PathVariable Long id, @RequestBody Administrador administradorActualizado){

        if(administradorActualizado == null){
            throw new RuntimeException("Administrador no encontrado con id: " + id);
        }
        return administradorService.actualizarAdministrador(id, administradorActualizado);
    }

    @PutMapping("/{id}")
    public String eliminarAdministrador(@PathVariable Long id){
        administradorService.eliminarAdministrador(id);
        return "administrador eliminado";
    }

    @GetMapping("/{id}")
    public Administrador obtenerAdministradoPorId (@PathVariable Long id){

        return administradorService.obtenerPorIdAministradores(id);
    }

    @PostMapping("/iniciarSesion")
    public ResponseEntity<String> iniciarSesionAdministrador (@RequestParam String email, @RequestParam String contrasenia){

        Administrador administrador = administradorService.iniciarSecionAdministrador(email, contrasenia);
        if (administrador != null) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }

    @GetMapping("/contar")
    public Long contarAdministradores(){
        
        return administradorService.contarAdministradores();
    }

    /*  @GetMapping("/{id}")
    public List<Admisnistrador> buscarAdministrador (@RequestParam String criterio){

        return administradorService.
    }*/


}
