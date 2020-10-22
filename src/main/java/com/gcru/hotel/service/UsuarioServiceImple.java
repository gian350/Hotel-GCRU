package com.gcru.hotel.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcru.hotel.model.Usuario;
import com.gcru.hotel.repository.UsuarioRepository;

@Service("UsuarioService")
@Transactional
public class UsuarioServiceImple implements UsuarioService{

	 @Autowired
	 UsuarioRepository usuarioRepository;

	 @Override
	 public Usuario saveUser(Usuario usuario) {
	    return usuarioRepository.save(usuario);
	 }

	 @Override
	 public Usuario deleteUser(Long id) {
	     Optional<Usuario> usuario = usuarioRepository.findById(id);
	     if(usuario.isPresent()) {
	         usuarioRepository.deleteById(id);
	         return usuario.get();
	     }
	     return usuario.get();
	 }

	 @Override
	 public List<Usuario> findAllUsers() {
	    return usuarioRepository.findAll();
	 }

	 @Override
	 public Usuario findOne(Long id) {
	     Optional<Usuario> obj = usuarioRepository.findById(id);
	     if(obj.isPresent()) return obj.get();
	     return null;
	 }

	 @Override
	 public Usuario updateUser(Usuario user) {
	     // TODO Auto-generated method stub
	     Long id = user.getIdUsuario();
	     Optional<Usuario> u = usuarioRepository.findById(id);

	     if(u.isPresent()) {
	         u.get().setDni(user.getDni());
	         u.get().setIdUsuario(user.getIdUsuario());
	         u.get().setNombre(user.getNombre());
	         u.get().setRol(user.getRol());
	         u.get().setHabitaciones(user.getHabitaciones());

	         usuarioRepository.save(u.get());

	     }
	     return u.get();

	  }

}
