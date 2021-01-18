package com.indra.curso.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indra.curso.empleos.model.vacante;

@Service
public class vacantesService implements IVacantesService{
	
	
	private List<vacante> lista=null;
	public vacantesService() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<vacante>();
		try {
			// Creamos la oferta de Trabajo 1.
			vacante vacante1 = new vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil"); // Titulo de la vacante
			vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal.");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(8000.0);
			vacante1.setDestacado(1);
		    vacante1.setImagen("empresa1.png");
						
			// Creamos la oferta de Trabajo 2.
			vacante vacante2 = new vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado.");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			// Creamos la oferta de Trabajo 3.
			vacante vacante3 = new vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Eléctrico");
			vacante3.setDescripcion("Empresa internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica.");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);
			
			// Creamos la oferta de Trabajo 4.
			vacante vacante4 = new vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Gráfico");
			vacante4.setDescripcion("Solicitamos Diseñador Gráfico titulado para diseñar publicidad de la empresa.");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(7500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			/**
			 * Agregamos los 4 objetos de tipo Vacante a la lista ...
			 */
			lista.add(vacante1);			
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);

		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
	
	
	public List<vacante> buscarTodas() {
		
		return lista;
	}


	@Override
	public vacante buscarporID(Integer vacanteID) {
		for(vacante v:lista) {
			if(v.getId()==vacanteID) {
				return v;
			}
		}
		return null;
	}

}
