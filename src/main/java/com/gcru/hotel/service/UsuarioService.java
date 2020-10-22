package com.gcru.hotel.service;

import java.util.List;

import com.gcru.hotel.model.Usuario;

public interface UsuarioService {

	Usuario saveUser(Usuario usuario);

    Usuario deleteUser(Long id);

    Usuario updateUser(Usuario user);

    List<Usuario> findAllUsers();

    Usuario findOne(Long id);
}
