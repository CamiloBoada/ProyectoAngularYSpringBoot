package com.seguridad.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seguridad.springboot.app.models.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(Usuario usuario) {
		em.persist(usuario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return em.createQuery("from Usuario").getResultList();
	}


	
	@Override
	public Usuario login(String username, String password) {
		try {
			return (Usuario) em
					.createQuery("SELECT u FROM Usuario u where u.usuario = :username and u.password = :password")
					.setParameter("username", username).setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
