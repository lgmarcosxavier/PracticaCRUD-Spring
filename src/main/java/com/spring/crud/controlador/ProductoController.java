package com.spring.crud.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // para marcarla como clae MVC y sea cargada en el contenedor de Spring
@RequestMapping(path = "/producto") // path raiz de todos las rutas de este controlador
public class ProductoController {

    @GetMapping(path = "/consultar")
	public ModelAndView consultarClientesActivos() {
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("producto/consultar"); // buscara en el recurso producto/consultar
		return modelo;
	}
}