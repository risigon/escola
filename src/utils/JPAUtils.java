package utils;

import javax.persistence.*;

public class JPAUtils {
	private final static EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("conexao_DB");
	
	public static EntityManager criarManager() {
		return fabrica.createEntityManager();
	}
}
