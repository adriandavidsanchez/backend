package com.biblioteca.backend.Services;

import com.biblioteca.backend.entities.Administrador;
import java.util.List;

public interface AdministradorService {

    List<Administrador> obtenerLosAdministradores();

    Administrador obtenerPorIdAministradores(Long id);

    Administrador ingresarAdministrativoNuevo(Administrador administrador);

    Administrador actualizarAdministrador(Long id, Administrador administrador);

    void eliminarAdministrador(Long id);

    Long contarAdministradores();
}
