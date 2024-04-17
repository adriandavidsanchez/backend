package com.biblioteca.backend.Services;

import java.util.List;
import com.biblioteca.backend.model.Usuario;

public interface UsuarioService {

    List<Usuario> obtenerTodosUsuarios();

    Usuario obtenerPorUsuarioId(Long id);

    Usuario ingresarUsuarioNuevo(Usuario usuario);

    Usuario actualizarUsuario(Long id,Usuario usuario);

    void eliminarUsuario(Long id);

    Long contarUsuarios();

    List<Usuario> buscarUsuario (String criterio);

    Usuario iniciarSecionUsuario(String email, String contrasenia);
}
