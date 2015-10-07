package inVoiceData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConnection {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public HibernateConnection() {

	}

	public void openHibernateConnection() {

		entityManagerFactory = Persistence
				.createEntityManagerFactory("myHibernateProject");
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

	}

	public void closeHibernateConnection() {

		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManagerFactory.close();

	}

	public void saveEntityInDatabase(Object entity) {

		entityManager.persist(entity);

	}

}
