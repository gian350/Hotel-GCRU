package com.gcru.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Habitacion;
import com.gcru.hotel.model.Usuario;


@Service
public interface HabitacionService {

	Habitacion saveHabitacion(Habitacion habi);
	
	Habitacion deleteHabitacion(Long idHabi);
	
	Habitacion updateHabitacion(Habitacion habi);
	
	List<Habitacion> findAllHabitacion();
	
	Habitacion findOne(Long id);
	
}
