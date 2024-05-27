package com.biblioteca.backend.Controllers;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biblioteca.backend.Services.UsuarioService;
import com.biblioteca.backend.model.Usuario;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/crear")
    public String mostrarFormularioCreacion (Model model){
        model.addAttribute("usuario", new Usuario());
        return "formulario-usuario";
    }

        @PostMapping
        public String crearUsuario (@ModelAttribute Usuario usuario, Model model){
            try{
                usuarioService.crearUsuario(usuario);
                return "redirect:/usuarios";
            }catch (Exception e) {
                model.addAttribute("error", "Hubo un error al crear el usuario");
                return "formulario-usuario";
            }
        }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario (@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        
        if (usuarioActualizado == null) {
        throw new RuntimeException("Usuario no encontrado con id: " + id);
    }
        return usuarioService.actualizarUsuario(  id, usuarioActualizado);

    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario (@PathVariable Long id){

        usuarioService.eliminarUsuario(id);
        return " usuario eliminado exitosamente";
    }

    //@PathVariable se utuliza para los id
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorUsuarioId(id);
    }

    //@RequestParam se utiliza para cadenas de texto
    @GetMapping
    public List<Usuario> buscarUsuario(@RequestParam String criterio) {
        return usuarioService.buscarUsuario(criterio);
    }

    @GetMapping("/contar")
    public Long obtenerTodosUsuarios(){
        return usuarioService.contarUsuarios();
    }

    @PostMapping("/iniciarSesion")
    public ResponseEntity<String> iniciarSesion (@RequestParam String email, @RequestParam String contrasenia){
        Usuario usuario = usuarioService.iniciarSecionUsuario(email, contrasenia);
        if (usuario != null) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }
}

