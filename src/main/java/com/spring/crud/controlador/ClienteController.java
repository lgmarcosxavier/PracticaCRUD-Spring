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

@Controller // para marcarla como clae MVC y sea cargada en el contenedor de Spring
@RequestMapping(path = "/cliente") // ruta raiz de todas las rutas de este controlador
public class ClienteController {
	// inyectamos la dependencias cuando cargue este controlador
	@Autowired // obtener el bean de "clienteRepository" autogenerado en el contenedor de beans de Spring
	ClienteRepository clienteRepository;
	
	@GetMapping(path = "/consultar")
	public ModelAndView consultarClientesActivos() {
		List<Cliente> clientes_limpios = new ArrayList<>();
		
		// obtenems todos los clientes pero solo mostraremos los que sean clientes con estado 1
		clienteRepository.findAll().forEach(cliente -> {
			if ( cliente.getEstado() == 1 ) {
				clientes_limpios.add(cliente);
			}
		});
		

		ModelAndView modelo = new ModelAndView();
		// agregamos la lista para que sea reconocida a la vista
		modelo.addObject("clientes", clientes_limpios); 
		modelo.setViewName("cliente/consultar"); // archivo enn templates "cliente/consultar"
		return modelo;
	}
	
	@GetMapping(path = "/crear")
	public ModelAndView agregarCliente() {
		ModelAndView modelo = new ModelAndView();  
		// solo agregamos una instancia de cliente a la vista, para saber qué tipo de modelo guardará
		modelo.addObject("cliente", new Cliente());
		modelo.setViewName("cliente/crear"); // archivo enn templates "cliente/crear"
		return modelo;
	}
	
	@PostMapping(path = "/registrar") // ruta mediante método POST
	public String registrarCliente(Cliente cliente, Model model) {
		cliente.setEstado(1); // por defecto el cliente activo sera estado 1
		// registramos el cliente
		clienteRepository.save(cliente);  // como el id del cliente estará nula, se registra como nuevo

		return "redirect:/cliente/consultar";
	}
	
	@GetMapping(path = "/editar")
	public ModelAndView editarCliente(
		// indica que que esta ruta get se pasa un parametor llamdaa "id", que es obligatorio
		// ejemplo: cliente/editar/1, cliente/editar/23
		@RequestParam(name = "id", required = true) Long id
		) {
		// buscamos un cliente con el id especificado, pero si no lo encuentra, devuelve null
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		ModelAndView modelo = new ModelAndView();  
		modelo.addObject("cliente", cliente); // agregamos el objeto a la vista para cargar sus datos
		modelo.setViewName("cliente/editar");
		return modelo;
	}
	
	@PostMapping(path = "/actualizar") // ruta mediante método POST
	public String actualizarCliente(Cliente cliente, Model model) {
		cliente.setEstado(1);
		// como el id del cliente no sera nula, lo actualizara
		clienteRepository.save(cliente); 

		return "redirect:/cliente/consultar";
	}
	
	@PostMapping(path = "/eliminar") // ruta mediante método POST
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
