package com.biblioteca.backend.Services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.UsuarioService;
import com.biblioteca.backend.model.Usuario;

import repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioBBDD = usuarioRepository.findById(id).orElse(null);
        if (usuarioBBDD != null) {
            usuarioBBDD.setNombre(usuario.getNombre());
            usuarioBBDD.setApellido(usuario.getApellido());
            usuarioBBDD.setEmail(usuario.getEmail());
            usuarioBBDD.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioBBDD.setNumeroContacto(usuario.getNumeroContacto());
            usuarioBBDD.setDireccion(usuario.getDireccion());
            return usuarioRepository.save(usuarioBBDD);
        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
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
                    usuario.getEmail().toLowerCase().contains(criterio.toLowerCase())) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }

    @Override
    public Usuario iniciarSecionUsuario(String email, String contrasenia) {
        //se busca en la base de datos el usuario
        Usuario usuario = usuarioRepository.findByEmail(email);
        //ver si el correo electronico y la contrasenia se encuentra en la base de datos
        if (usuario == null || !passwordEncoder.matches(usuario.getEmail(), contrasenia)) {
            throw new RuntimeException("Correo electrónico o contraseña incorrectos");
        }
        return usuario;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        //verificar si el correo ya esta registrado
        if(usuarioRepository.findByEmail(usuario.getEmail()) != null){
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        //codificar la catrasenia antes de guardar el usuario
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }
}
