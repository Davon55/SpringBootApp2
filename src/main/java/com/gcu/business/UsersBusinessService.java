package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataAccessInterface;
import com.gcu.data.UsersDataService;
import com.gcu.data.UsersDataServiceForRepository;

import com.gcu.model.UserEntity;
import com.gcu.model.UserModel;

public class UsersBusinessService implements UsersBusinessServiceInterface {
	
	//dependency injection configured in the Spring config file
	//to determine which database
	@Autowired
	UsersDataServiceForRepository service;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("This is a test");
	}
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init method of UserBusinessService");
		
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy method of UserBusinessService");
		
	}

	@Override
	public List<UserModel> getUsers() {
		//get list of entities
				List<UserEntity> usersE = service.getUsers();
				//create an empty list of users
				List<UserModel> user = new ArrayList<UserModel>();
				//for each entity in the list, create a new user and add users
				for(UserEntity entity: usersE) {
					user.add(
							//translate from entity to login model
							new UserModel(
									entity.getId(),
									entity.getFirstname(),
									entity.getLastname(),
									entity.getUsername(),
									entity.getPassword(),
									entity.getEmail()
									)
							);
				}
				return user;
	}


	@Override
	public UserModel getByID(int id) {
		UserEntity result = service.getByID(id);
		UserModel user = new UserModel(
				result.getId(),
				result.getFirstname(),
				result.getLastname(),
				result.getUsername(),
				result.getPassword(),
				result.getEmail()
				);
		return user;
	}


	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		
		//get list of entities
		List<UserEntity> usersE = service.searchUsers(searchTerm);
		//create an empty list of users
		List<UserModel> user = new ArrayList<UserModel>();
		//for each entity in the list, create a new users and add users
		for(UserEntity entity: usersE) {
			user.add(
					//translate from entity to login model
					new UserModel(
							entity.getId(),
							entity.getFirstname(),
							entity.getLastname(),
							entity.getUsername(),
							entity.getPassword(),
							entity.getEmail()
							)
					);
		}
		return user;
	}


	@Override
	public int addOne(UserModel newUser) {
		
		UserEntity entity = new UserEntity(
				newUser.getId(),
				newUser.getFirstname(),
				newUser.getLastname(),
				newUser.getUsername(),
				newUser.getPassword(),
				newUser.getEmail()
				);
		return service.addOne(entity);
	}


	@Override
	public boolean deleteOne(int id) {
		return service.deleteOne(id);
	}


	@Override
	public UserModel updateOne(int idToUpdate, UserModel updateUser) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity(
				updateUser.getId(),
				updateUser.getFirstname(),
				updateUser.getLastname(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				updateUser.getEmail()
				);
		UserEntity result = service.updateOne(idToUpdate, entity);
		
		UserModel updated = new UserModel(
				result.getId(),
				result.getFirstname(),
				result.getLastname(),
				result.getUsername(),
				result.getPassword(),
				result.getEmail()
				);
		return updated;
	}





}
