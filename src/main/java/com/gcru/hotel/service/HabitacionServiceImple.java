package com.gcru.hotel.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Habitacion;
import com.gcru.hotel.model.Usuario;
import com.gcru.hotel.repository.HabitacionRepository;

@Service("habitacionService")
@Transactional
public class HabitacionServiceImple implements HabitacionService {

	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Override
	public Habitacion saveHabitacion(Habitacion habi) {
		// TODO Auto-generated method stub
		Habitacion ha = null;
		if(habi != null) {
			ha = new Habitacion();
			ha = habitacionRepository.save(habi);
			return ha; 
		}
		return ha;
	}

	@Override
	public Habitacion deleteHabitacion(Long idHabi) {
		// TODO Auto-generated method stub
		Optional<Habitacion> habi = habitacionRepository.findById(idHabi);
		if(habi.isPresent()) {
			habitacionRepository.deleteById(idHabi);
			return habi.get();
		}
		return habi.get();
	}

	@Override
	public Habitacion updateHabitacion(Habitacion habi) {
		// TODO Auto-generated method stub
		Long id = habi.getIdHabitacion();
		Habitacion ca = null;
		if(habitacionRepository.findById(id).isPresent()) {
			ca = new Habitacion();
			ca.setIdHabitacion(habi.getIdHabitacion());
			ca.setEstadoActual(habi.getEstadoActual());
			ca.setCategoria(habi.getCategoria());
			habitacionRepository.save(ca);
			return ca;
		}
		return ca;
	}

	@Override
	public List<Habitacion> findAllHabitacion() {
		// TODO Auto-generated method stub
		return habitacionRepository.findAll();
	}
	
	
	public Habitacion findOne(Long id) {
		Optional<Habitacion> obj = habitacionRepository.findById(id);
	     if(obj.isPresent()) return obj.get();
	     return null;
	}

}
