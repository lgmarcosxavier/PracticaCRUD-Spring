package com.spring.crud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	@GetMapping("/")
	public String getInicio() {
		return "index";
	}
}
