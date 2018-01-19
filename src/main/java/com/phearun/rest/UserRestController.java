package com.phearun.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phearun.model.User;
import com.phearun.response.Response;
import com.phearun.response.ResponseList;
import com.phearun.service.UserService;

@RestController // @Controller + @ResponseBody
public class UserRestController {
	
	/**	
	 *  /users - GET : get all resources
	 *  /users - POST: create resource
	 *  /users/{id} - DELETE : remove resource
	 *  /users/{id} - PUT : update resourced
	 *  /users/{id} - GET : get single resource
	 *  /users/{id} - PATCH : partial update  
	 */
	
	@Autowired
	private UserService userService;
	
	/*@GetMapping("/users")
	public Map<String, Object> getAllUsers(){
		Map<String, Object> response = new HashMap<>();
		List<User> users = userService.getAllUsers();
		
		if(users.isEmpty()){
			response.put("message", "No user data!");
			response.put("status_code", HttpStatus.NO_CONTENT.value());
			return response; 
		}
		response.put("data", users);
		response.put("message", "Successfully!");
		
		return response;
	}*/
	
	@GetMapping("/users")
	public Response getAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()){
			return new Response("No user data!"); 
		}
		return new ResponseList("Successfully!", users);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		User user = userService.getUserById(id);
		if(user == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user){
		boolean status = userService.createUser(user);
		if(status){
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> removeUser(@PathVariable Integer id){
		boolean status = userService.removeByUserId(id);
		if(status)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
		boolean status = userService.updateUser(user);
		if(status)
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
