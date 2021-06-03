package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<>();
	private static int userCount = 3;
	
	static {
		
		userList.add(new User(1, "Adam", new Date()));
		userList.add(new User(2, "Eve", new Date()));
		userList.add(new User(3, "Charles", new Date()));
		
	}
	
	public List<User> findAll (){
		
		return userList;
	}
	
	public User findUser(int id) {
		
		for(User user: userList)
		{
			if (user.getId() == id)
			return user;
		}
		
		
		return null;
	}
	
	public User add(User user) {
	
		if(user.getId() == null) {
			
			user.setId(++userCount );
		}
		userList.add(user);
		return user;
	}
	
}
