package com.gcru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcru.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{

}
