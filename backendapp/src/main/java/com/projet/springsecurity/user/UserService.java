package com.projet.springsecurity.user;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User savUser(User user);
    public User updateUser(Long id,User user);
    public boolean deleteUser(Long id);
}
