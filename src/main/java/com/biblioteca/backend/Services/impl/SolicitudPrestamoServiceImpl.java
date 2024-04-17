package com.biblioteca.backend.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biblioteca.backend.Services.SolicitudPrestamoService;
import repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImpl implements SolicitudPrestamoService {

    @Autowired
    private SolicitudPrestamoRepository solicitudPrestamoRepository;

}
