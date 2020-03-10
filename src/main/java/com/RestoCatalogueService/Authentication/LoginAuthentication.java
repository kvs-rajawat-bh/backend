package com.RestoCatalogueService.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestoCatalogueService.User;
import com.RestoCatalogueService.UserRepository;

@RestController
public class LoginAuthentication {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	@CrossOrigin(origins="*")
	public User validateLogin(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		System.out.println("validating...");
		User user=null;
		try {
			user = userRepo.findByUsernameAndPassword(username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return user;
	}

}
