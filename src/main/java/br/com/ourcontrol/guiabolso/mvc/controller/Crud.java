package br.com.ourcontrol.guiabolso.mvc.controller;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import br.com.ourcontrol.guiabolso.utils.JPAUtil;
import br.com.ourcontrol.guiabolso.utils.Transactional;

public class Crud implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Crud.class);

	protected EntityManager manager = JPAUtil.getEntityManager();

	public Object porId(Class classe, Long id) {
		return manager.find(classe, id);
	}

	@Transactional
	public void persistir(Object o) {
		manager.persist(o);
	}

	@Transactional
	public void remove(Object o) {
		manager.remove(o);
	}

	@Transactional
	public void altera(Object o) {
		manager.merge(o);
	}

}
