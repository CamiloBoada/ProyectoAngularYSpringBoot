package com.seguridad.springboot.app.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.seguridad.springboot.app.models.dao.IUsuarioDao;
import com.seguridad.springboot.app.models.entity.Usuario;

@SpringBootTest
public class UsuarioControllerTest {
	
	@InjectMocks
	private UsuarioController usuarioController;
	
	@Mock
	private IUsuarioDao usuarioDao;
	

		
	
	@Test
	public void testListarUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setApellido("Boada");
		usuario.setNombre("Camilo");
		usuario.setPassword("123456");
		usuario.setUsuario("Camilo976");
		
		
		
		Mockito.when(usuarioDao.listar()).thenReturn(Arrays.asList(usuario));
		
		List<Usuario> expectResult = Arrays.asList(usuario);
		
		String expectResultUsuario = "yeisbogessss1";
		
		List<Usuario> result = usuarioController.listar(); 
		
		assertThat(result.get(0).getUsuario().equals(expectResultUsuario));
	
	}

}
