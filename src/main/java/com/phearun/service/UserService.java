package com.phearun.service;

import java.util.List;

import com.phearun.model.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public boolean removeByUserId(Integer id);
	public boolean createUser(User user);
	public boolean updateUser(User user);
}
