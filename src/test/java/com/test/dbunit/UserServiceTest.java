package com.test.dbunit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.config.DBType;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.ebi.spring.dbunit.test.RollbackTransactionalDataSetTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/testService-context.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DataSetTestExecutionListener.class,
    RollbackTransactionalDataSetTestExecutionListener.class})
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	@Rollback(true)
    @DataSet(dbType = DBType.HSQLDB, locations = "classpath:/userData.xml")
	public void findUserById(){
	
		User user=userService.findUser(1l);
		//verify information
		assertEquals("1",user.getId().toString());
	}
	
	@Test
	@Rollback(true)
    @DataSet(dbType = DBType.HSQLDB, locations = "classpath:/userData.xml")
	public void shouldSaveUser(){
	
		User user=new User();
		user.setEmail("abc@d.com");
		user.setFirstName("abc");
		user.setLastName("xyz");
		
		user=userService.addUser(user);
		
		//verify information
		assertEquals("2",user.getId().toString());
	}
	
	@Test
	@Rollback(true)
    @DataSet(dbType = DBType.HSQLDB, locations = "classpath:/userData.xml")
	public void shouldDelete(){
	
		
		User user=userService.findUser(1l);
		userService.deleteUser(user);
		
		Iterable<User> users=userService.findUsers();
		
		List<User> list=new ArrayList<User>();
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User dbUser = (User) iterator.next();
			list.add(dbUser);
		}
		
		//verify information
		assertEquals(0,list.size());
	}
	
}
