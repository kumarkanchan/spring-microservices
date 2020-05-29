package com.rest.webservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	// GET /users
	// retriveAllUsers
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return service.findAll();
	}

	// GET /users/{id}
	// retriveUser(int id)
	@GetMapping("/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id) {//User
		//return service.FindOne(id);
		User user=service.FindOne(id);
		//handling exception
		if(user==null) 
			throw new UserNotFoundException("id-"+ id);	
		
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
				Resource<User> resource = new Resource<User>(user);
				
				ControllerLinkBuilder linkTo = 
						         linkTo(methodOn(this
								.getClass())
								.retriveAllUsers());
				                 resource.add(linkTo.withRel("all-users"));
				
				//HATEOAS
				return resource;
			//return user;
	}
	
    //DELETE
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=service.deleteById(id);
		
		if(user==null) 
			throw new UserNotFoundException("id-"+ id);		
	}
	/*//
	// input - details of user
	// output - CREATED & Return the created URI
	@PostMapping("/users")
     public void  createUser(@RequestBody User user) {
     User saveUser=service.save(user);
    	 */
	//
	// input - details of user
	// output - CREATED & Return the created URI
	//@valid
	//HATEOAS
	@PostMapping("/users")
     public ResponseEntity<Object>  createUser(@Valid @RequestBody User user) {
    	 User saveUser=service.save(user);
    	 
    	// CREATED
    	// /user/{id} --4    savedUser.getId()
    		
    	URI location=ServletUriComponentsBuilder
    			    .fromCurrentRequest()
    			    .path("/{id}")
    			    .buildAndExpand(saveUser.getId())
    			    .toUri();
    	return ResponseEntity.created(location).build();
     }
}

