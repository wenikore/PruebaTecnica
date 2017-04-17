package com.demo.boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.demo.boot.model.Vendedores;
import com.demo.boot.repository.VendRepository;
import com.demo.boot.service.VendeService;
import com.demo.boot.util.ErrorComun;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebController {
	static final Logger logger = LogManager.getLogger(WebController.class.getName());

	@Autowired
	VendeService vendeService;

	/* ---------------------------listar vendedores------------------------- */
	@RequestMapping(value = "/vendedores/", method = RequestMethod.GET)
	public ResponseEntity<List<Vendedores>> listarTodo() {
		List<Vendedores> vendedor = vendeService.findBytodovendedores();
		if (vendedor.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vendedores>>(vendedor, HttpStatus.OK);
	}

	/*
	 * ------------------------buscar vendedores x cedula----------------------
	 */

	@RequestMapping(value = "/vendedores/{cedula}", method = RequestMethod.GET)
	public ResponseEntity<?> obtenerVendedor(@PathVariable("cedula") String cedula) {
		logger.info("Fetching User with id {}", cedula);
		Vendedores vendedor = vendeService.findBycedula(cedula);
		if (vendedor == null) {
			logger.info("Fetching User with id {}", cedula);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Vendedores>(vendedor, HttpStatus.OK);
	}
	/* ---------------------------crear vendedores------------------------- */

	@RequestMapping(value = "/vendedores/", method = RequestMethod.POST)
	public ResponseEntity<?> crearVendedor(@RequestBody Vendedores vendedores, UriComponentsBuilder ucBuilder) {
		System.out.println("*************************" + vendedores);
		logger.info("creating Vendedor: {}", vendedores);
		if (vendeService.existeVendedor(vendedores)) {
			logger.error("el usuario a registrar ya existe,", vendedores.getNombrevendedor());
			return new ResponseEntity(new ErrorComun("el vendedor ay existe" + vendedores.getCc()),
					HttpStatus.CONFLICT);
		}
		vendeService.guardarVendedor(vendedores);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("app/api/vendedores/{id}").buildAndExpand(vendedores.getCc()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}
	/*---------------------------actualizar vendedores-------------------------*/

	@RequestMapping(value = "/vendedores/{cedula}", method = RequestMethod.PUT)
	public ResponseEntity<?> actualizarvendedor(@PathVariable("cedula") String cc, @RequestBody Vendedores vendedores) {
		logger.info("creating Vendedor: {}", cc);
		Vendedores buscaVende;
		buscaVende = vendeService.findByid(cc);
		if (buscaVende == null) {
			logger.error("el recurso que esta buscando no esta disponible", cc);
			return new ResponseEntity(new ErrorComun("Recurso no invalido"), HttpStatus.NOT_FOUND);
		}
		// buscaVende.setCc(vendedores.getCc());
		buscaVende.setNombrevendedor(vendedores.getNombrevendedor());
		buscaVende.setApellidovendedor(vendedores.getApellidovendedor());
		vendeService.actualizarVendedor(buscaVende);
		return new ResponseEntity<Vendedores>(buscaVende, HttpStatus.OK);
	}

	// -----------------------------eliminar vendedores-------------//
	@RequestMapping(value = "/vendedores/{cedula}", method = RequestMethod.DELETE)
	public ResponseEntity<Vendedores> eliminarVendedor(@PathVariable("cedula") String cc) {
		Vendedores buscaVende;
		buscaVende = vendeService.findByid(cc);

		if (buscaVende == null) {
			logger.error("data no encontrado", cc);
			return new ResponseEntity(new ErrorComun("Recurso no encontrado"), HttpStatus.NOT_FOUND);
		}
		vendeService.eliminarByCCVendedor(cc);
		return new ResponseEntity<Vendedores>(HttpStatus.ACCEPTED);
	}

}
