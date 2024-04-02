package com.refresh.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.refresh.entities.User;
import com.refresh.repositories.UserRepository;

@Service
public class UserService {
	
	//private List<User> storeData = new ArrayList<>();
	 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	// NOW WE ARE USING DATABASE SO WE DONT NEED IT 
	
//	public UserService()
//	{
//		storeData.add(new User(UUID.randomUUID().toString(),
//				"HARISH PALASPAGAR","harish@gmail.com"
//				));
//		storeData.add(new User(UUID.randomUUID().toString(),
//				"RAJESH PALASPAGAR","rajesh@gmail.com"
//				));
//		storeData.add(new User(UUID.randomUUID().toString(),
//				"AKSHAY PALASPAGAR","akshay@gmail.com"
//				));
//		storeData.add(new User(UUID.randomUUID().toString(),
//				"ANKIT PALASPAGAR","ankit@gmail.com"
//				));
//	}
	
	
	
	
	
	
	public List<User> getUser()
	{
	 return this.userRepository.findAll();
	}
	
	public User createUser(User user)
	{
	user.setId(UUID.randomUUID().toString());
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	return userRepository.save(user);
	
	}
	
	
}
