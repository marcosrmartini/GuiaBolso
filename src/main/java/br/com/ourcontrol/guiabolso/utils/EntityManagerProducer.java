package br.com.ourcontrol.guiabolso.utils;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ourcontrol.guiabolso.sistema.Constantes;

@ApplicationScoped
public class EntityManagerProducer implements Serializable{

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);
	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}

}
