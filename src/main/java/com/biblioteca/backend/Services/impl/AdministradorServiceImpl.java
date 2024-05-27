package com.biblioteca.backend.Services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.AdministradorService;
import com.biblioteca.backend.model.Administrador;
import repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl  implements AdministradorService{

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override// controller listo
    public Administrador actualizarAdministrador(Long id, Administrador administrador) {
        Administrador administradorBBDD = administradorRepository.findById(id).orElse(null);
        if ((administradorBBDD != null)) {
            administradorBBDD.setNombre(administrador.getNombre());
            administradorBBDD.setApellido(administrador.getApellido());
            administradorBBDD.setEmail(administrador.getEmail());
            administradorBBDD.setFechaNacimiento(administrador.getFechaNacimiento());
            administradorBBDD.setNumeroContacto(administrador.getNumeroContacto());
            administradorBBDD.setDirecion(administrador.getDirecion());
            return administradorRepository.save(administradorBBDD);
        }
        return null;
    }

    @Override
    public Long contarAdministradores() {
        return administradorRepository.count();
    }

    @Override// controller listo
    public void eliminarAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }

    @Override
    public Administrador ingresarAdministrativoNuevo(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public List<Administrador> obtenerLosAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Administrador obtenerPorIdAministradores(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    @Override//
    public Administrador iniciarSecionAdministrador(String email, String contrasenia) {
        
        Administrador administrador= administradorRepository.findByEmail(email);
        if (administrador == null || !passwordEncoder.matches(administrador.getEmail(), contrasenia)) {
            throw new RuntimeException("Correo electrónico o contraseña incorrectos");
        }
        return administrador;
    }

    @Override//
    public Administrador crearAdministrador(Administrador administrador) {
        
        if(administradorRepository.findByEmail(administrador.getEmail()) != null){
            throw new RuntimeException("El correo electrónico ya está registrado");
        }
        administrador.setContrasenia(passwordEncoder.encode(administrador.getContrasenia()));
        return administradorRepository.save(administrador);
    }
}
