package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

@Autowired
private	UserDaoService userDaoService;

@GetMapping(path="/users")
public List<User> retrieveAllUsers(){
		
		return userDaoService.findAll();
	
}

@GetMapping(path="/user/{id}")
public User retrieveUser (@PathVariable int id)
{
	User user = userDaoService.findUser(id);
	if (user == null)
	throw new UserNotFoundException("id - "+id);
	
	return user;
}
 
@PostMapping(path ="/user")
public ResponseEntity<User> addUser( @RequestBody User user) {
	
	userDaoService.add(user);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}.").buildAndExpand(user.getId()).toUri();
	
	return ResponseEntity.created(location).build();
}

}


