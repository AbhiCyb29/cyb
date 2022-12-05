package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.dao.IUserDao;
import com.cybage.model.ERole;
import com.cybage.model.Role;
import com.cybage.model.User;

@SpringBootTest
class UserServiceTest {
	private ERole eRole;

	@Autowired
	UserDetailsServiceImpl service;

	@MockBean
	IUserDao userDao;

	@Autowired
	IUserDao userRepo;
	

	Long id = (long) 1;
	String username = "gauri";
	String email = "Gauri@gmail.com";
	String password = "Gauri@123";
	User user = new User();
	Set<Role> roles = new HashSet<>();
	List<User> users = new ArrayList<>();
	

	public UserServiceTest() {
	user.setId(id);
	user.setUsername(username);
	user.setEmail(email);
		user.setPassword(password);
	user.setRoles(roles);
	users.add(user);
	}

	@BeforeEach
	void setup() {

		Role user = new Role(4, ERole.USER);
		Set<Role> roles = new HashSet<>();
		roles.add(user);
		Optional<User> user1 = Optional.of(new User((long) 1, "abc", "abc@mail.com", "abhi@123", roles));
		Mockito.when(userDao.findById((long) 1)).thenReturn(user1);

	}

	@Test
	void getUserById_Sucess() {
		Long id = (long) 1;
		User user = service.getById(id);
		System.out.println(user.getRoles());
		assertEquals(id, user.getId());
	}

	@Test
	void testGetAllEmployees() {
		Mockito.when(userRepo.findAll()).thenReturn(users);
		assertThat(service.getUsers()).isEqualTo(users);
	}
//
//    @Test
//    void testAddUser() {
//                    Mockito.when(userRepo.save(user)).thenReturn(user);
//                    assertThat(service.getById(id)).isEqualTo(user);
//    }


//  @Test
//  public void declineUserIfSameUserName() {
//                  User userToBeTested = new User("abc", "abc@mail.com", "abhi@123", "9850909090", "inactive", null, null, null);
//                  Mockito.when(userDao.save(userToBeTested)).thenReturn(userToBeTested);
//                  Optional<User> findUserByName = userDao.findById("abc");
//                  if (findUserByName != null) {
//                                  Exception exception = assertThrows(ResourceAlreadyExistException.class, () -> {
//                                                  assertEquals(userToBeTested, userService.createNewUser(userToBeTested));
//                                  });
//                                  String expectedMessage = "User does not exist";
//                                  String actualMessage = exception.getMessage();
//
//                                  assertTrue(actualMessage.contains(expectedMessage));
//                  }
//  }

}
