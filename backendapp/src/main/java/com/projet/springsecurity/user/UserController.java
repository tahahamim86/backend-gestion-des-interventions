package com.projet.springsecurity.user;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserServiceImpl userServiceImpl;

public UserController(UserServiceImpl userServiceImpl){
    this.userServiceImpl=userServiceImpl;
}
@GetMapping()
@PreAuthorize("hasRole('ADMIN') and hasAuthority('READ_USER')")
public ResponseEntity<?> getAllUsers() {
    List<User> users = this.userServiceImpl.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}
    
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('READ_ONE_USER')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = this.userServiceImpl.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    

        @PostMapping()
        @PreAuthorize("hasRole('ADMIN') and hasAuthority('CREATE_USER')")
    public ResponseEntity<?> addUser(@RequestBody User users) {
        return new ResponseEntity<>(this.userServiceImpl.savUser(users), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('UPDATE_ONE_USER')")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userServiceImpl.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null); // You can handle this more gracefully
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('DELETE_ONE_USER')")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            boolean isDeleted = userServiceImpl.deleteUser(id);
            if (!isDeleted) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
