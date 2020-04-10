package com.seguridad.springboot.app.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seguridad.springboot.app.models.dao.IUsuarioDao;
import com.seguridad.springboot.app.models.entity.Usuario;

@RestController
@RequestMapping("/app")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Usuario usuario) {
		usuarioDao.save(usuario);
		return "redirect:login";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<Usuario> listar() {
		return usuarioDao.listar();
		
	}
	
	@RequestMapping(value="/guardar", method=RequestMethod.POST)
	public String guardarUsuario(@RequestBody Usuario usuario) {
		usuarioDao.save(usuario);
		return "Se ha guardado el usuario";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioLogin = usuarioDao.login(usuario.getUsuario(), usuario.getPassword());
		if(usuarioLogin != null) {
			return "Bienvenido";
		}else {
			throw new EntityNotFoundException("Usuario y/o contraseña incorrecta");
		}
		
		
	}
	
}
