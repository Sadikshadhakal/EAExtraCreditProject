package mum.edu.cs544.dao;

import mum.edu.cs544.domain.Task;

public interface ITaskDAO {
	public void createTask(Task task);
	public void updateTask(Task task);
}
