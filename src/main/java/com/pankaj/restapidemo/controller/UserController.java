package com.pankaj.restapidemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.restapidemo.exception.RecordNotFoundException;
import com.pankaj.restapidemo.model.User;
import com.pankaj.restapidemo.repository.UserRepository;

@RestController
public class UserController {

	private final UserRepository repository;

	UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/user")
	List<User> getAllUsers() {
		return (List<User>) repository.findAll();
	}

	@PostMapping("/user")
	User addUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}

	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
	}

	@PutMapping("/user/{id}")
	User updateUserDetails(@RequestBody User newUser, @PathVariable Long id) {

		return repository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}

	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
