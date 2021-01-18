	package com.indra.curso.empleos.service;
	
	import java.util.List;
	
	import com.indra.curso.empleos.model.vacante;
	
	public interface IVacantesService {
		List<vacante> buscarTodas();
		vacante buscarporID(Integer vacanteID);
	}
