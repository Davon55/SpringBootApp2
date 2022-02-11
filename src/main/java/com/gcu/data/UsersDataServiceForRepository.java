package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.model.UserEntity;

@Service
public class UsersDataServiceForRepository implements UsersDataAccessInterface<UserEntity> {
	
	//users repository is defined as the CrudRepository in Spring
	@Autowired
	private UsersRepository usersRepository;
	//dataSource is defined in the application properties file
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	//none default constructor for constructor injection
	public UsersDataServiceForRepository(UsersRepository usersRepository, DataSource dataSource)
	{
		this.usersRepository = usersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	@Override
	public UserEntity getByID(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findById((int) id).orElse(null);
	}

	@Override
	public List<UserEntity> getUsers() {
		List<UserEntity> result = (List<UserEntity>) usersRepository.findAll();
		return result;
	}

	@Override
	public List<UserEntity> searchUsers(String searchTerm) {
		List<UserEntity> result = usersRepository.findByFirstNameContainingIgnoreCase(searchTerm);
		return result;
	}

	@Override
	public int addOne(UserEntity newUser) {
		UserEntity result = usersRepository.save(newUser);
		if(result == null)
		{
			return 0;
		}
		return (int) result.getId();
	}

	@Override
	public boolean deleteOne(int id) {
		usersRepository.deleteById(id);
		return true;
	}

	@Override
	public UserEntity updateOne(int idToUpdate, UserEntity updateOrder) {
		UserEntity result = usersRepository.save(updateOrder);
		return result;
	}



}
