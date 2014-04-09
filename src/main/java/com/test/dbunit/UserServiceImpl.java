package com.test.dbunit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.dbunit.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	public User findUser(long id) {
		// TODO Auto-generated method stub
	
		return userRepository.findOne(id);
	}

	public Iterable<User> findUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return  userRepository.save(user);
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
		return true;
	}

}
