package com.gcru.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcru.hotel.model.Categoria;
import com.gcru.hotel.model.Habitacion;
import com.gcru.hotel.service.CategoriaService;
import com.gcru.hotel.service.HabitacionService;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

	
	@Autowired
	HabitacionService habitacionService;
	
	//GET
    @RequestMapping(value="/habitaciones", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Habitacion>> getHabitacion() {
    	
		List<Habitacion> categorias = new ArrayList<>();
		categorias = habitacionService.findAllHabitacion();
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categorias);
		
	}
    
    //POST
  	@RequestMapping(value="/createHabitacion", method = RequestMethod.POST, headers = "Accept=application/json")
  	public ResponseEntity<Habitacion> createHabitacion(@RequestBody Habitacion habi){
  		
  		if (habi.getCategoria() == null) {
  			return new ResponseEntity<Habitacion>(HttpStatus.NO_CONTENT);
  		}else {
  	  		Habitacion ca = habitacionService.saveHabitacion(habi);
  	  		return new ResponseEntity<Habitacion>(ca, HttpStatus.CREATED);
  		}
  		

  	}
    
  	
  	//PUT
  	@RequestMapping(value="/updateHabitacion",method = RequestMethod.PUT,headers = "Accept=application/json")
  	public ResponseEntity<Habitacion> updateHabitacion(@RequestBody Habitacion habi){
  		
  		
  		if(habi != null) {
  			String estadoAntiguo = habitacionService.findOne(habi.getIdHabitacion()).getEstadoActual();
  			Habitacion currentHabitacion = habitacionService.updateHabitacion(habi);
  	  		String estadoNuevo = habi.getEstadoActual();
  	  		
  	  		System.out.println(estadoAntiguo);
  	  		System.out.println(estadoNuevo);
  	  		
  	  		if((estadoAntiguo.equals("libre") && estadoNuevo.equals("ocupada")) || 
  	  		(estadoAntiguo.equals("libre") && estadoNuevo.equals("mantenimiento"))  ||
  	  		(estadoAntiguo.equals("ocupada") && estadoNuevo.equals("mantenimiento")) ||
  	  		(estadoAntiguo.equals("ocupada") && estadoNuevo.equals("limpieza")) ||
  	  		(estadoAntiguo.equals("limpieza") && estadoNuevo.equals("libre")) ||
  	  		(estadoAntiguo.equals("limpieza") && estadoNuevo.equals("mantenimiento")) ||
  	  		(estadoAntiguo.equals("mantenimiento") && estadoNuevo.equals("libre")) ||
  	  		(estadoAntiguo.equals("mantenimiento") && estadoNuevo.equals("limpieza")) 
  	  		) {
	  	  		if(currentHabitacion == null) {
		  			return new ResponseEntity(HttpStatus.NOT_FOUND);
		  		}else {
		  			return new ResponseEntity<Habitacion>(currentHabitacion,HttpStatus.OK); 
		  		}
  	  		}else {
  	  			return new ResponseEntity(HttpStatus.BAD_REQUEST);
  	  		}
  	  		

  	  			
  	  			
	  	  	
  	  		
  		}
  		
  		return new ResponseEntity(HttpStatus.BAD_REQUEST);
  		
  		
  		
  	}
    
 
  	@RequestMapping(value="/deleteHabitacion/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
	//@PathVariable sirve para declarar un parametro como variable que se utilizara en la ruta del @RequestMapping, en este caso sera el id
	public ResponseEntity<Habitacion> deleteCategoriaById(@PathVariable Long id){
		
  		Habitacion ca = habitacionService.deleteHabitacion(id);
		if(ca != null) {
			return new ResponseEntity<Habitacion>(ca,HttpStatus.OK); 
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
  //GET
    @RequestMapping(value="/habitacionesXestado/{estado}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Habitacion>> getHabitacionByEstado(@PathVariable String estado) {
    	
		List<Habitacion> categorias = new ArrayList<>();
		categorias = habitacionService.findAllHabitacion();
		
		ArrayList<Habitacion> categoriasEstado = new ArrayList<>();
		for(int i=0;i<categorias.size();i++) {
			if(categorias.get(i).getEstadoActual().equals(estado)) {
				categoriasEstado.add(categorias.get(i));
			}
		}
		if (categoriasEstado.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categoriasEstado);
		
	}
    
  //GET
    @RequestMapping(value="/habitacionesXcategoria/{categoria}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Habitacion>> getHabitacionByCategoria(@PathVariable String categoria) {
    	
		List<Habitacion> categorias = new ArrayList<>();
		categorias = habitacionService.findAllHabitacion();
		
		ArrayList<Habitacion> categoriasCategoria = new ArrayList<>();
		for(int i=0;i<categorias.size();i++) {
			if(categorias.get(i).getCategoria().getNombre().equals(categoria)) {
				categoriasCategoria.add(categorias.get(i));
			}
		}
		if (categoriasCategoria.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categoriasCategoria);
		
	}
  	
  	
	
	
}
