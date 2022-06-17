package com.takeo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDAOService daoService;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {

		return daoService.findAll();
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		User savedused = daoService.save(user);
		System.out.println(savedused);
	}
	
	//retrive specific user details
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		User user=daoService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("ID: "+ id);
		return user ;
	}
	
	//retrive specific user details
		@DeleteMapping("/users/{id}")
		public void deleteUser(@PathVariable int id) {
			User user=daoService.deleteById(id);
			if(user==null)
			{
				throw new UserNotFoundException("ID: "+ id);

			}
			System.out.println(user);
		}
}
