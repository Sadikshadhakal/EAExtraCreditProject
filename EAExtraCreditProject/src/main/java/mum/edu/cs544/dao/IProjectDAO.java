package mum.edu.cs544.dao;

import java.util.List;

import mum.edu.cs544.domain.Project;

public interface IProjectDAO {
	void createProject(Project project);
	void updateProject(Project project);
	List<Project> searchProjectByResource(String resource);
	List<Project> searchProjectByKeyword(String keyword);
	List<Project> searchProjectByLocation(String location);
	List<Project> getAllProjectsHavingVolunteer();
}
