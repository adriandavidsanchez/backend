package com.biblioteca.backend.Services;

import com.biblioteca.backend.entities.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> obtenerTodosUsuarios();

    Usuario obtenerPorUsuarioId(Long id);

    Usuario ingresarUsuarioNuevo(Usuario usuario);

    Usuario actualizarUsuario(Long id,Usuario usuario);

    void eliminarUsuario(Long id);

    Long contarUsuarios();
}
