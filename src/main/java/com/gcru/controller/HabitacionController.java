package com.gcru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcru.model.Habitacion;
import com.gcru.repositories.HabitacionRepository;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @GetMapping("/hola")
    public String getHola() {
        return "hola mundo";
    }

}

