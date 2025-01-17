package com.mahmudul.krishibandhuapi.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
  
  UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/{userId}")
  public Optional<User> getUser(@PathVariable Long userId) {
    return userRepository.findById(userId);
  }
  
  @PostMapping("/create")
  public ResponseEntity<Void> createUser(@RequestBody User data) {
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getId()).toUri();
    return ResponseEntity.created(location).build();
  }
  
}
