package com.biblioteca.backend.Services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.UsuarioService;
import com.biblioteca.backend.model.Usuario;

import repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder contraseniaEnconder;

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if (usuarioBBDD != null) {
            usuarioBBDD.setNombre(usuario.getNombre());
            usuarioBBDD.setEmail(usuario.getEmail());
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

    @Override
    public List<Usuario> buscarUsuario(String criterio) {
        List<Usuario> resultados = new ArrayList<>();
        for (Usuario usuario : obtenerTodosUsuarios()) {
            if (usuario.getNombre().toLowerCase().contains(criterio.toLowerCase()) ||
                    usuario.getApellido().toLowerCase().contains(criterio.toLowerCase()) ||
                    usuario.getNumeroDocumento().toLowerCase().contains(criterio.toLowerCase())) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    @Override
    public Usuario iniciarSecionUsuario(String email, String contrasenia) {

        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null || !contraseniaEnconder.matches(usuario.getEmail(), contrasenia)) {
            throw new RuntimeException("Correo electrónico o contraseña incorrectos");
        }
        return usuario;
    }

}
