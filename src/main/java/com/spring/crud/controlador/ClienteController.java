package com.spring.crud.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.crud.modelo.entidad.Cliente;
import com.spring.crud.modelo.repositorio.ClienteRepository;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {
	@Autowired // obtener el bean de "clienteRepository" autogenerado en el contenedor de beans de Spring
	ClienteRepository clienteRepository;
	
	@GetMapping(path = "/consultar")
	public ModelAndView consultarClientesActivos() {
		List<Cliente> clientes_limpios = new ArrayList<>();
		
		clienteRepository.findAll().forEach(cliente -> {
			if ( cliente.getEstado() == 1 ) {
				clientes_limpios.add(cliente);
			}
		});
		

		ModelAndView modelo = new ModelAndView();
		modelo.addObject("clientes", clientes_limpios);
		modelo.setViewName("cliente/consultar");
		return modelo;
	}
	
	@GetMapping(path = "/crear")
	public ModelAndView agregarCliente() {
		ModelAndView modelo = new ModelAndView();  
		modelo.addObject("cliente", new Cliente());
		modelo.setViewName("cliente/crear");
		return modelo;
	}
	
	@PostMapping(path = "/registrar")
	public String registrarCliente(Cliente cliente, Model model) {
		cliente.setEstado(1);
		clienteRepository.save(cliente);

		return "redirect:/cliente/consultar";
	}
	
	@GetMapping(path = "/editar")
	public ModelAndView editarCliente(@RequestParam(name = "id", required = true) Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		ModelAndView modelo = new ModelAndView();  
		modelo.addObject("cliente", cliente);
		modelo.setViewName("cliente/editar");
		return modelo;
	}
	
	@PostMapping(path = "/actualizar")
	public String actualizarCliente(Cliente cliente, Model model) {
		cliente.setEstado(1);
		clienteRepository.save(cliente);

		return "redirect:/cliente/consultar";
	}
	
	@PostMapping(path = "/eliminar")
	public String eliminarCliente(@RequestParam(name = "id", required = true) Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if ( cliente != null ) {
			//clienteRepository.delete(cliente);
			cliente.setEstado(0);
			clienteRepository.save(cliente);
		}
		
		return "redirect:/cliente/consultar";
	}
}
