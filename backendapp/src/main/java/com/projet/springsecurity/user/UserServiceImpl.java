package com.projet.springsecurity.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
@Data
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
    if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " not found"));
    }

    @Override
    public User savUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return this.userRepository.save(user);
    }
    @Override
    public User updateUser(Long id, User user) {
        // Validate inputs
        if (id == null || user == null) {
            throw new IllegalArgumentException("ID or User cannot be null");
        }
    
        // Retrieve the existing user from the database
        User existingUser = getUserById(id);
        
        // Check if the user exists
        if (existingUser == null) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    
        // Update existingUser with new user details
        existingUser.setName(user.getName());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
    
        // Save the updated user to the repository
        return this.userRepository.save(existingUser);
    }
    
    @Override
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Example: Assuming 'role' is a field in your User entity and it's of type Role enum
            Role userRole = user.getRole(); // Replace with your actual way of getting user's role

            // Check if user's role is valid
            if (userRole != null && Arrays.stream(Role.values()).anyMatch(role -> role.equals(userRole))) {
                userRepository.deleteById(id);
                return true;
            } else {
                // Handle invalid role scenario
                throw new IllegalArgumentException("Invalid role for user with id " + id);
            }
        }
        return false;
    }

}
