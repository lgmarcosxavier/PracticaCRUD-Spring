package com.spring.crud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/producto")
public class ProductoController {
    @GetMapping(path = "/consultar")
	public ModelAndView consultarClientesActivos() {
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("producto/consultar");
		return modelo;
	}
}