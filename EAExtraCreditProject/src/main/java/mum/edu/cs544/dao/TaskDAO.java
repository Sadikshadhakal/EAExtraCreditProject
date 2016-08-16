package mum.edu.cs544.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mum.edu.cs544.domain.Task;

public class TaskDAO implements ITaskDAO{

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("extraCredit");
		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void createTask(Task task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(task);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void updateTask(Task task) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Task t = new Task();
			Query query = em.createQuery("FROM Task t WHERE t.taskId =:taskId");
			query.setParameter("taskId", task.getTaskId());
			t = (Task) query.getSingleResult();
			em.remove(t);
			em.persist(task);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

}
