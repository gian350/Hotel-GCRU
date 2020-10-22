package com.gcru.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Habitacion;


@Service
public interface HabitacionService {

	void saveHabitacion(Habitacion habi);
	
	Habitacion deleteHabitacion(Long idHabi);
	
	Habitacion updateHabitacion(Habitacion habi);
	
	List<Habitacion> findAllHabitacion();
	
}
