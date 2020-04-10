package com.seguridad.springboot.app.models.dao;

import java.util.List;

import com.seguridad.springboot.app.models.entity.Usuario;

public interface IUsuarioDao {
	public void save(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario login(String username, String password);
}
