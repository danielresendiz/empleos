package com.indra.curso.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.indra.curso.empleos.model.vacante;
import com.indra.curso.empleos.service.IVacantesService;
import com.indra.curso.empleos.service.vacantesService;


@Controller
public class homeController {
	@Autowired
	private IVacantesService vacanteService;  
	
	@GetMapping("/tabla")
	public String mostrartabla(Model model) {
		List<vacante> lista=vacanteService.buscarTodas();
		model.addAttribute("lista", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model ) {
		vacante vacante=new vacante();
		vacante.setNombre("Ingeniero de sistema");
		vacante.setDescripcion("se solicita empleado");
		vacante.setFecha(new Date());
		vacante.setSalario(97000.0);
		model.addAttribute("vacante",vacante);
		return "detalle";
	}
	@GetMapping("/lista")
	public String mostrarlistado(Model model) {
		List<String> List=new LinkedList<String>();
		List.add("Ingeniero");
		List.add("Auxiliar");
		List.add("Vendedor");
		List.add("Doctor");
		model.addAttribute("empleos",List);
		return "listado";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<vacante> lista=vacanteService.buscarTodas();
		model.addAttribute("lista", lista);
		return "home";
	}
	
	
}
