package com.seguridad.springboot.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seguridad.springboot.app.controllers.UsuarioController;

@SpringBootTest
class SpringBootLoginApplicationTests {

	@Autowired
	private UsuarioController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
