package mum.edu.cs544.service;

import java.util.List;

import mum.edu.cs544.dao.IProjectDAO;
import mum.edu.cs544.dao.ITaskDAO;
import mum.edu.cs544.dao.IUserDAO;
import mum.edu.cs544.dao.ProjectDAO;
import mum.edu.cs544.dao.TaskDAO;
import mum.edu.cs544.dao.UserDAO;
import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.Users;


public class Service implements IService {
	IUserDAO userDAO = new UserDAO();
	ITaskDAO taskDAO = new TaskDAO();
	IProjectDAO projectDAO = new ProjectDAO();

	public void createNewUser(Users user) {
		userDAO.createUser(user);
	}

	public void createNewProject(Project project) {
		projectDAO.createProject(project);
	}

	public void createNewTask(Task task) {
		taskDAO.createTask(task);
	}
	
	public List<Users> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}
}
