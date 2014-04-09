package com.test.dbunit;
import com.test.dbunit.User;

public interface UserService {

	User findUser(long id);
	Iterable<User> findUsers();
	User addUser(User user);
	boolean deleteUser(User user);
}
