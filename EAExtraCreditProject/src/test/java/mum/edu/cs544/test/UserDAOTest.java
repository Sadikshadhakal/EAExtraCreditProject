package mum.edu.cs544.test;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mum.edu.cs544.domain.UserType;
import mum.edu.cs544.domain.Users;
import mum.edu.cs544.service.IService;
import mum.edu.cs544.service.Service;

public class UserDAOTest {
	IService service = new Service();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		Path path = FileSystems.getDefault().getPath("C:\\tmp", "vcredist.bmp");
		System.out.println(".........Create New User........");
		Users user = new Users();
		user.setUserName("Sadiksha Dhakal");
		user.setEmail("sadikshadhakal@gmail.com");
		user.setGender("Female");
		user.setAddress("1000 St. North, Fairfield, Iowa");
		user.setPassword("abcde");
		user.setRole(UserType.VOLUNTEER);
		
		service.createNewUser(user);

	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Sadiksha Dhakal",service.getAllUsers().get(0).getUserName());
	}

}
