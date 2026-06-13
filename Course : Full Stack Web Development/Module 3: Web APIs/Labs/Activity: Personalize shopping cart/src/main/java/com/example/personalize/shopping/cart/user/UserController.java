package com.example.personalize.shopping.cart.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		userService.createUser(user);
		return ResponseEntity.ok("User registered successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {

		User userByUsername = userService.getUserByUsername(user.getUsername());

		boolean isAuthenticated = userService.authenticate(user);
		return isAuthenticated ?
				ResponseEntity.status(HttpStatus.OK)
						.body(String.valueOf(userByUsername.getId())) :
				ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body("Login failed");
	}
}
