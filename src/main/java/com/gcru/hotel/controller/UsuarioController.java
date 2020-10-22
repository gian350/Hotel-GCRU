package com.gcru.hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcru.hotel.model.Habitacion;
import com.gcru.hotel.model.Usuario;
import com.gcru.hotel.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    //GET
    @RequestMapping(value="/usuarios", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Usuario>> getUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioService.findAllUsers();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

     //POST
      @RequestMapping(value="/createUser", method = RequestMethod.POST, headers = "Accept=application/json")
      public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){

          if (usuario == null) return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);

          usuarioService.saveUser(usuario);
          return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
      }

      @PutMapping(value = "/reserva", headers = "Accept=application/json")
      public ResponseEntity<Usuario> reserva(@RequestBody Usuario user) {
        
         Usuario obj = usuarioService.updateUser(user);
         if(obj == null) {
        	 return new ResponseEntity<Usuario>(obj,HttpStatus.NOT_FOUND); 
         }else {
        	 return new ResponseEntity<Usuario>(obj,HttpStatus.OK); 
         }
         
        
      }
      
      
}