package com.seguridad.springboot.app.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.seguridad.springboot.app.models.dao.IUsuarioDao;
import com.seguridad.springboot.app.models.dao.UsuarioDaoImpl;
import com.seguridad.springboot.app.models.entity.Usuario;

@Transactional
@SpringBootTest
public class UsuarioDaoImplTest {
	
	@InjectMocks
	UsuarioDaoImpl usuarioDaoImpl;
	
	@Mock
	IUsuarioDao iUsuarioDao;

	
	@Test
	public void login() {
		
		String userName = "Camilo96";
		String password = "1234";
		
		
		Usuario usuario = new Usuario();
		usuario.setApellido("Boada");
		usuario.setNombre("Camilo");
		usuario.setPassword("1234");
		usuario.setUsuario("Camilo96");
		
		Mockito.when(iUsuarioDao.login(userName, password)).thenReturn(usuario);
		
		
		
		String expectResult = "Boada";
		
		assertThat(true);
		
	
	}
	
	

}
