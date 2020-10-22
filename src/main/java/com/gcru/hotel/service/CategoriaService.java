package com.gcru.hotel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Categoria;
import com.gcru.hotel.model.Habitacion;


public interface CategoriaService {

	void saveCategoria(Categoria cate);
	
	Categoria deleteCategoria(Long idCate);
	
	Categoria updateCategoria(Categoria cate);
	
	List<Categoria> findAllCategoria();

}
