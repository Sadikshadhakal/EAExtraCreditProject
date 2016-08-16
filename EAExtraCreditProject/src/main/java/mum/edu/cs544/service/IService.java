package mum.edu.cs544.service;

import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.Users;

public interface IService {
	void createNewUser(Users user);
	void createNewProject(Project project);
	void createNewTask(Task task);
}
