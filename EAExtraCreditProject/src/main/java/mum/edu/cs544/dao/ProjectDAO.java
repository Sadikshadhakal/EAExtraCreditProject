package mum.edu.cs544.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import mum.edu.cs544.domain.Project;

public class ProjectDAO implements IProjectDAO {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("extraCredit");
		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	public void createProject(Project project) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(project);
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

	public void updateProject(Project project) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Project p = new Project();
			Query query = em.createQuery("FROM Project p WHERE p.projectId =:projectId");
			query.setParameter("projectId", project.getProjectId());
			p = (Project) query.getSingleResult();
			em.remove(p);
			em.persist(project);
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

	public List<Project> searchProjectByResource(String resource) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		List<Project> projects = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM Project p JOIN p.tasks t WHERE t.resourceRequired like :skill");
			query.setParameter("skill", "%" + resource + "%");
			projects = query.getResultList();
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
		return projects;
	}

	public List<Project> searchProjectByKeyword(String keyword) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		List<Project> projects = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM Project p WHERE p.projectname like :key");
			query.setParameter("key", "%" + keyword + "%");
			projects = query.getResultList();
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
		return projects;
	}

	public List<Project> searchProjectByLocation(String location) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		List<Project> projects = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM Project p WHERE p.location like :location");
			query.setParameter("location", "%" + location + "%");
			projects = query.getResultList();
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
		return projects;
	}

	public List<Project> getAllProjectsHavingVolunteer() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		List<Project> projects = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery("FROM Project p JOIN p.tasks t WHERE COUNT(p.users)>=1 ORDER BY t.time");
			projects = query.getResultList();
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
		return projects;
	}

}
