package com.seguridad.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seguridad.springboot.app.models.dao.IUsuarioDao;
import com.seguridad.springboot.app.models.entity.Usuario;

@RestController
@RequestMapping("/app")
public class UsuarioController {
	@Autowired
	private IUsuarioDao usuarioDao;
	/*
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String crear(Map<String,Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario de Usuario");
		return "form";
	}
	*/
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(Usuario usuario) {
		usuarioDao.save(usuario);
		return "redirect:login";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<Usuario> listar() {
		return usuarioDao.listar();
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody Usuario usuario) {
		Usuario usuario2=usuarioDao.login(usuario.getUsuario(), usuario.getPassword());
		
		if(usuario2!=null) {
			return "bienvenido";
		}else {
			return "Contraseña y/o Usuario Incorrecto";
		}
		
	}
	
	@RequestMapping(value="/guardar", method=RequestMethod.POST)
	public String guardarUsuario(@RequestBody Usuario usuario) {
		usuarioDao.save(usuario);
		return "Se ha guardado el usuario";
		
	}
	
}
