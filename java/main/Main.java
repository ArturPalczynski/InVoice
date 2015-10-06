package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Address;
import domain.Customer;

public class Main {

	public static void main(String[] args) {
		
		

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("myHibernateProject");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
	

		entityManager.getTransaction().begin();
		
		entityManager.getTransaction().commit();
		

		
		entityManager.clear();
		entityManagerFactory.close();
	}
	
	

}
//<property name="hibernate.hbm2ddl.auto" value="create" />