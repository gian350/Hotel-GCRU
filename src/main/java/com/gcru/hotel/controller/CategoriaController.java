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
import com.gcru.hotel.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	CategoriaService categoriaService;
    
	//GET
    @RequestMapping(value="/categorias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Categoria>> getCategorias() {
    	
		List<Categoria> categorias = new ArrayList<>();
		categorias = categoriaService.findAllCategoria();
		if (categorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(categorias);
		
	}
    
    //POST
  	@RequestMapping(value="/createCategoria", method = RequestMethod.POST, headers = "Accept=application/json")
  	public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria cate){
  		
  		if (cate == null) {
  			return new ResponseEntity<Categoria>(HttpStatus.NO_CONTENT);
  		}
  		
  		Categoria ca = categoriaService.saveCategoria(cate);
  		return new ResponseEntity<Categoria>(ca, HttpStatus.CREATED);
  	}
    
  	
  	//PUT
  	@RequestMapping(value="/updateCategoria",method = RequestMethod.PUT,headers = "Accept=application/json")
  	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria cate){
  		
  		Categoria currentCategoria = categoriaService.updateCategoria(cate);
  		if(currentCategoria == null) {
  			return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
  		}else {
  			return new ResponseEntity<Categoria>(currentCategoria,HttpStatus.OK); 
  		}
  	}
    
 
  	@RequestMapping(value="/deleteCategoria/{id}",method = RequestMethod.DELETE,headers = "Accept=application/json")
	//@PathVariable sirve para declarar un parametro como variable que se utilizara en la ruta del @RequestMapping, en este caso sera el id
	public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable Long id){
		
		Categoria ca = categoriaService.deleteCategoria(id);
		if(ca != null) {
			return new ResponseEntity<Categoria>(ca,HttpStatus.OK); 
		}else {
			return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		}
		
	}
  	
  	public String [] vector = {"estandar","normal","suite"};
  	
	public boolean buscarNombreCate(String nombre) {
		for(int i = 0;i<vector.length;i++) {
	  		if(nombre.equals(vector[i])) {
	  			return true;
	  		}
	  	}
		return false;
	}
    

}

