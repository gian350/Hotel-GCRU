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
	HabitacionService categoriaService;
	
	//GET
    @RequestMapping(value="/habitaciones", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Habitacion>> getHabitacion() {
    	
		List<Habitacion> categorias = new ArrayList<>();
		categorias = categoriaService.findAllHabitacion();
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categorias);
		
	}
    
    //POST
  	@RequestMapping(value="/createHabitacion", method = RequestMethod.POST, headers = "Accept=application/json")
  	public ResponseEntity<Habitacion> createHabitacion(@RequestBody Habitacion habi){
  		System.out.print(habi.getEstadoActual());
  		
  		if (habi == null) {
  			return new ResponseEntity(HttpStatus.NO_CONTENT);
  		}
  		
  		categoriaService.saveHabitacion(habi);
  		return new ResponseEntity<Habitacion>(habi, HttpStatus.CREATED);
  	}
    
  	
  	//PUT
  	@RequestMapping(value="/updateHabitacion",method = RequestMethod.PUT,headers = "Accept=application/json")
  	public ResponseEntity<Habitacion> updateHabitacion(@RequestBody Habitacion habi){
  		
  		Habitacion currentHabitacion = categoriaService.updateHabitacion(habi);
  		if(currentHabitacion == null) {
  			return new ResponseEntity(HttpStatus.NOT_FOUND);
  		}else {
  			return new ResponseEntity<Habitacion>(currentHabitacion,HttpStatus.OK); 
  		}
  	}
    
 
  	@RequestMapping(value="/deleteHabitacion/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
	//@PathVariable sirve para declarar un parametro como variable que se utilizara en la ruta del @RequestMapping, en este caso sera el id
	public ResponseEntity<Habitacion> deleteCategoriaById(@PathVariable Long id){
		
  		Habitacion ca = categoriaService.deleteHabitacion(id);
		if(ca != null) {
			return new ResponseEntity<Habitacion>(ca,HttpStatus.OK); 
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
