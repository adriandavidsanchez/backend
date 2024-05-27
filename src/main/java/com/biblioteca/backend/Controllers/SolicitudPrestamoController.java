package com.biblioteca.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.backend.Services.SolicitudPrestamoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import com.biblioteca.backend.model.SolicitudPrestamo;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudPrestamoController {

    @Autowired
    private SolicitudPrestamoService solicitudPrestamoService;

    @PostMapping("/nueva")
    public SolicitudPrestamo solicitarPrestamo(@RequestBody SolicitudPrestamo solicitud) {
        return solicitudPrestamoService.solicitarPrestamo(solicitud);
    }

    @PutMapping("/{id}/aprobar")
    public SolicitudPrestamo aprobarPrestamo(@PathVariable Long id) {
        return solicitudPrestamoService.aprobarPrestamo(id);
    }

    @PutMapping("/{id}/rechazar")
    public SolicitudPrestamo rechazarPrestamo(@PathVariable Long id) {
        return solicitudPrestamoService.rechazarPrestamo(id);
    }

    @PutMapping("/{id}/devolver")
    public SolicitudPrestamo devolverLibro(@PathVariable Long id) {
        return solicitudPrestamoService.devolverLibro(id);
    }

    @GetMapping
    public List<SolicitudPrestamo> obtenerTodasLasSolicitudes() {
        return solicitudPrestamoService.obternerSolicitudesPrestamo();
    }

    @DeleteMapping("/{id}/eliminarsolicitud")
    public String eliminarSolicitudPrestamo (@PathVariable Long id){

        solicitudPrestamoService.eliminarSolicitudPrestamo(id);
        return "La solicitud fue eliminada ";
    }

    @GetMapping
    public SolicitudPrestamo obtenerSolicitusPorId (@PathVariable Long id){

        return solicitudPrestamoService.obtenerPorId(id);
    }
}
