package com.takeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	public static int usersCount = 5;

	private static List<User> users = new ArrayList<>();

	// static block execute only one entire the application
	static {
		users.add(new User(1, "Manoj", new Date()));
		users.add(new User(2, "anoj", new Date()));
		users.add(new User(3, "noj", new Date()));
		users.add(new User(4, "Manoj", new Date()));
		users.add(new User(5, "Man", new Date()));

	}

	// Method that retrieve all users from the list
	public List<User> findAll() {

		return users;
	}

	// method to add the user in the list
	public User save(User user) {

		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	//method that find a particular user from the list
	public User findOne(int id)
	{
		for (User user:users) {
			if (user.getId()==id)
				return user;
		}
		return null;
	}

	public User deleteById(int id)
	{
		for (User user:users) {
			if (user.getId()==id) {
				
			users.remove(user);
				return user;
		}
		}
		return null;
	}
	
}
