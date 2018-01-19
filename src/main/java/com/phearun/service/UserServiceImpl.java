package com.phearun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.phearun.model.User;

@Service
public class UserServiceImpl implements UserService{

	private List<User> users;
	
	public UserServiceImpl() {
		users = new ArrayList<>();
		users.add(new User(1, "Dara"));
		users.add(new User(2, "Chana"));
		users.add(new User(3, "Bopha"));
		users.add(new User(4, "Thida"));
	}
	
	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public User getUserById(Integer id) {
		for(User user: users){
			if(id == user.getId())
				return user;
		}
		return null;
	}

	@Override
	public boolean removeByUserId(Integer id) {
		for(int i=0; i<users.size(); i++){
			if(id == users.get(i).getId()){
				users.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean createUser(User user) {
		return users.add(user);
	}

	@Override
	public boolean updateUser(User user) {
		for(int i=0; i<users.size(); i++){
			if(user.getId() == users.get(i).getId()){
				users.set(i, user);
				return true;
			}
		}
		return false;
	}
	
}
