package com.spring.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.crud.modelo.entidad.Proveedor;
import com.spring.crud.modelo.repositorio.ProveedorRepository;

@Controller
@RequestMapping(path = "/proveedor")
public class ProveedorController {
	@Autowired
	ProveedorRepository proveedorRepository;

    @GetMapping(path = "/consultar")
	public ModelAndView consultarProveedoresActivos() {
		ModelAndView modelo = new ModelAndView();
		return modelo;
	}

	@GetMapping(path = "/crear")
	public ModelAndView agregarProveedor() {
		ModelAndView modelo = new ModelAndView();  
		modelo.addObject("proveedor", new Proveedor());
		modelo.setViewName("proveedor/crear");
		return modelo;
	}

	@PostMapping(path = "/registrar")
	public String registrarProveedor(Proveedor proveedor, Model model) {
		return "redirect:/proveedor/consultar";
	}

	@GetMapping(path = "/editar")
	public ModelAndView editarProveedor(@RequestParam(name = "id", required = true) Long id) {
		ModelAndView modelo = new ModelAndView();  
		modelo.addObject("proveedor", null); // buscar el proveedor que corresponda al id del request
		modelo.setViewName("proveedor/editar");
		return modelo;
	}

	@PostMapping(path = "/actualizar") // ruta mediante método POST
	public String actualizarProveedor(Proveedor proveedor, Model model) {
		return "redirect:/proveedor/consultar";
	}
	
	@PostMapping(path = "/eliminar") // ruta mediante método POST
	public String eliminarProveedor(@RequestParam(name = "id", required = true) Long id) {
		return "redirect:/proveedor/consultar";
	}
}