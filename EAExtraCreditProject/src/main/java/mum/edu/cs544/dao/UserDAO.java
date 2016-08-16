package mum.edu.cs544.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mum.edu.cs544.domain.Users;


public class UserDAO implements IUserDAO{
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("extraCredit");
		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	
	public void createUser(Users user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(user);
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	public boolean authenticateUser(Users User) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		Users user = new Users();
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM User u where u.userId = :userId");
			query.setParameter("userId",user.getUserId());
			user = (Users) query.getSingleResult();
			if(user!=null){
				if(user.getPassword().equals(user.getPassword()))
				{
					return true;
				}
			}
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return false;
	}
	
	public List<Users> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		List<Users> userlist = new ArrayList<Users>();
		
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM User user");
			userlist = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return userlist;
	}

}
