package mum.edu.cs544.control;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.UserType;
import mum.edu.cs544.domain.Users;
import mum.edu.cs544.service.IService;
import mum.edu.cs544.service.Service;

public class Application {

	public static void main(String[] args) {
		IService serv = new Service();

		Path path = FileSystems.getDefault().getPath("C:\\tmp", "vcredist.bmp");
		System.out.println(".........Create New User........");
		Users user = new Users();
		user.setUserName("Sadiksha Dhakal");
		user.setEmail("sadikshadhakal@gmail.com");
		user.setGender("Female");
		user.setAddress("1000 St. North, Fairfield, Iowa");
		user.setPassword("abcde");
		user.setRole(UserType.VOLUNTEER);

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

		serv.createNewUser(user);
		serv.createNewTask(task1);
		serv.createNewTask(task2);
		serv.createNewProject(project);

		System.out.println("Completed!!!!");

	}
}
