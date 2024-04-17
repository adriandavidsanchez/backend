package com.biblioteca.backend.Services;

import java.util.List;
import com.biblioteca.backend.model.Administrador;

public interface AdministradorService {

    List<Administrador> obtenerLosAdministradores();

    Administrador obtenerPorIdAministradores(Long id);

    Administrador ingresarAdministrativoNuevo(Administrador administrador);

    Administrador actualizarAdministrador(Long id, Administrador administrador);

    void eliminarAdministrador(Long id);

    Long contarAdministradores();

    Administrador iniciarSecionAdministrador(String email, String contrasenia);
}
