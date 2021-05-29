package com.example.demo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserService {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/Users")	
	public List<User> retriveAll(){
		
		return service.findall();
	}
	
	@GetMapping("/Users/{id}")
	public User retriveuser(@PathVariable Integer id){
		
		
				User retriveduser=service.findOne(id);
				if(retriveduser==null)
                       throw new UserNotFoundException("id-"+id);
			
				return retriveduser;
	}
	
	//added Valid annotation for spring validater api
	@PostMapping("/Users")
	public ResponseEntity adduser(@Valid @RequestBody User user){
		
		User saveduser=service.save(user);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveduser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/delete/{id}")
	public User delete(@PathVariable Integer id){
		
		User retriveduser=service.delete(id);
		if(retriveduser==null)
               throw new UserNotFoundException("id-"+id);
	
		return retriveduser;
	}

}
