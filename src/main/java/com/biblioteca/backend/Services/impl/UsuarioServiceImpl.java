package com.biblioteca.backend.Services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.UsuarioService;
import com.biblioteca.backend.entities.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if(usuarioBBDD != null){
            usuarioBBDD.setNombre(usuario.getNombre());
            usuarioBBDD.setCorreo(usuario.getCorreo());
            return usuarioRepository.save(usuarioBBDD);
        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario ingresarUsuarioNuevo(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerPorUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Long contarUsuarios() {
        return usuarioRepository.count();
    }

}
