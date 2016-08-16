package mum.edu.cs544.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.service.IService;
import mum.edu.cs544.service.Service;

public class ProjectDAOTest {
	IService service = new Service();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("........Create New Project.......");
		Project project = new Project();
		project.setProjectName("In Campus Volunteering Project");
		project.setProjectStatus("Incomplete");
		project.setDescription(
				"This project is all about helping different international as well as national students who might be in need of help");
		project.setLocation("Iowa, Fairfield");
		project.setSkills("Communication");
		project.setStartDate("2016-01-01");
		project.setEndDate("2020-01-01");

		System.out.println("........ Create Tasks for" + project.getProjectName() + "............");
		Task task1 = new Task();
		task1.setTaskName("Tree Plantation in Campus");
		task1.setTaskStatus("In Progress");
		task1.setResource("small tree, spades, water");
		task1.setTime(2.0);

		Task task2 = new Task();
		task2.setTaskName("Book Donation");
		task2.setTaskStatus("In Progress");
		task2.setResource("Old used books, New books");
		task2.setTime(5.5);

		project.setTaskList(Arrays.asList(task1, task2));

		
		service.createNewTask(task1);
		service.createNewTask(task2);
		service.createNewProject(project);

	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("In Campus Volunteering Project",service.getAllProjects().get(0).getProjectName());
	}

}
