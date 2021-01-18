package com.indra.curso.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.curso.empleos.model.vacante;
import com.indra.curso.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class vacantesController {
	

	@Autowired
	private IVacantesService vacanteService;  
	
	@GetMapping("/create")
	public String crear() {
		return "vacante/formVacante";
	}
	
	@PostMapping("/save")
	public String guardar(vacante Vacante) {
		System.out.println("Vacante:"+Vacante);

		
		
		return "vacante/listVacantes";	
	}
	
	
	@GetMapping("/view/{idVacante}")
	public String verdetalle(@PathVariable int idVacante,Model model) {
		vacante vacantes=vacanteService.buscarporID(idVacante);
		System.out.println("Vacante: "+ vacantes);
		model.addAttribute("vacante", vacantes);
		return "detalle";
	}
	
	@GetMapping("/delete")
	public String Eliminar(@RequestParam("id") int idVacante,Model model) {
		System.out.println("se ha eiminador Vacante con ID: "+ idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
