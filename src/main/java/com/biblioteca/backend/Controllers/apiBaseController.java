package com.biblioteca.backend.Controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@ControllerAdvice
@OpenAPIDefinition(
    info = @Info(
        title = "Api backend",
        version = "1.0",
        description = "Gestion de una biblioteca"
    ),
    tags = {
        @Tag(
            name = "Base Controller",
            description = "Controlador base para ;a api, este controlado se extendera a todos los endpoints"
        )
        
    }
)
public class apiBaseController {

}
