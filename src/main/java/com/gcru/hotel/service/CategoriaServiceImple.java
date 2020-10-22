package com.gcru.hotel.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Categoria;
import com.gcru.hotel.repository.CategoriaRepository;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImple implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public void saveCategoria(Categoria cate) {
		// TODO Auto-generated method stub
		categoriaRepository.save(cate);
	}

	@Override
	public Categoria deleteCategoria(Long idCate) {
		// TODO Auto-generated method stub.
		Optional<Categoria> ca = categoriaRepository.findById(idCate);
		if(ca.isPresent()) {
			categoriaRepository.deleteById(idCate);	
			return ca.get();
		}
		return ca.get();
	}

	@Override
	public Categoria updateCategoria(Categoria cate) {
		// TODO Auto-generated method stub
		Long id = cate.getIdCategoria();
		Categoria ca = null;
		if(categoriaRepository.findById(id).isPresent()) {
			ca = new Categoria();
			ca.setIdCategoria(cate.getIdCategoria());
			ca.setNombre(cate.getNombre());
			ca.setCantidadLimite(cate.getCantidadLimite());
			categoriaRepository.save(ca);
		
		}
		return ca;
		
	}
	
	
	
	

	@Override
	public List<Categoria> findAllCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	

}
