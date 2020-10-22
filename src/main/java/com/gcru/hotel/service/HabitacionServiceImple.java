package com.gcru.hotel.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Habitacion;
import com.gcru.hotel.repository.HabitacionRepository;

@Service("habitacionService")
@Transactional
public class HabitacionServiceImple implements HabitacionService {

	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Override
	public void saveHabitacion(Habitacion habi) {
		// TODO Auto-generated method stub
		if(habi != null) {
			habitacionRepository.save(habi);
		}
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

}
