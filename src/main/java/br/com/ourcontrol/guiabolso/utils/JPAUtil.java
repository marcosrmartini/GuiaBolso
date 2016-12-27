package br.com.ourcontrol.guiabolso.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ourcontrol.guiabolso.sistema.Constantes;

public class JPAUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
