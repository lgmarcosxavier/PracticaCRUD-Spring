package com.spring.crud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // para marcarla como clae MVC y sea cargada en el contenedor de Spring
public class InicioController {

	@GetMapping("/") // ruta mediante el método get
	public String getInicio() {
		return "index"; // devuelve el archivo "index.html" de los recursos template
	}
}
