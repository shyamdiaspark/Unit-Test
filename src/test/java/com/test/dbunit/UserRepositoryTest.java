package com.test.dbunit;

import static org.junit.Assert.*;

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
@ContextConfiguration("classpath:/testRepository-context.xml")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DataSetTestExecutionListener.class,
    RollbackTransactionalDataSetTestExecutionListener.class})
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@Rollback(true)
    @DataSet(dbType = DBType.HSQLDB, locations = "classpath:/userData.xml")
	public void findUserById(){
	
		User user=userRepository.findOne(1l);
		
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
		
		user=userRepository.save(user);
		
		//verify information
		assertEquals("2",user.getId().toString());
		assertEquals(2,userRepository.count());
	}
	
	@Test
	@Rollback(true)
    @DataSet(dbType = DBType.HSQLDB, locations = "classpath:/userData.xml")
	public void shouldDelete(){
	
		
		userRepository.delete(1l);
		
		//verify information
		assertEquals(0,userRepository.count());
	}
	
}
