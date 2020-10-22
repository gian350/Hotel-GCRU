package com.gcru.hotel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcru.hotel.model.Habitacion;

@Repository
@Transactional
public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{

}
