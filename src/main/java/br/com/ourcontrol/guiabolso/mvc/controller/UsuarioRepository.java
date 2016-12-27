package br.com.ourcontrol.guiabolso.mvc.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import br.com.ourcontrol.guiabolso.mvc.model.Usuario;

public class UsuarioRepository extends Crud {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(UsuarioRepository.class);
	
	public Boolean validarUsuario(String login, String senha) {
		log.info("Realizando pesquisa ...");
		Usuario usuario = null;
		try {
			//TypedQuery<Usuario> query = manager.createQuery("from Usuario where login = :login and senha = :senha", Usuario.class);
			TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.validarUsuario", Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			usuario = query.getSingleResult();
		} catch (NoResultException e) {
			log.error(e);
			return false;
		}
		return true;
	}
	
	public List<Usuario> listagem(){
		TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findAll", Usuario.class);
		return query.getResultList();
	}
}
