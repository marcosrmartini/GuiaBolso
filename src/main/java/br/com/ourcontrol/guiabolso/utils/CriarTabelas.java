package br.com.ourcontrol.guiabolso.utils;

import javax.persistence.Persistence;

import br.com.ourcontrol.guiabolso.sistema.Constantes;

public class CriarTabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT);
	}
	
}
