package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.model.UserModel;

@Repository
public class UsersDAO implements UsersDataAccessInterface<UserModel> {
	
	private List<UserModel> users = new ArrayList<UserModel>();
	
	public UsersDAO(){
		users = new ArrayList<UserModel>();
		users.add(new UserModel(0, "Donnell", "Sample", "Davon55", "Donnell55", "dondon@gmail.com" ));
	}
	

	@Override
	public UserModel getByID(int id) {
		
		return users.stream()
		.filter(user -> user.getId() == id)
		.findFirst()
		.get();
	}

	@Override
	//return all users
	public List<UserModel> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOne(UserModel newUser) {
		boolean success = users.add(newUser);
		
		System.out.println("Added one item");
		if(success) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean deleteOne(int id) {
		users.removeIf(users -> users.getId() == id);
		
		System.out.println("Removed an item");
		return true;
	}

	@Override
	public UserModel updateOne(int idToUpdate, UserModel updateUser) {
		
		//find the matching user
		users.stream().forEach(users ->{
			if(users.getId() == idToUpdate) {
				users.setFirstname(updateUser.getFirstname());
				users.setLastname(updateUser.getLastname());
				users.setUsername(updateUser.getUsername());
				users.setPassword(updateUser.getPassword());
				users.setEmail(updateUser.getEmail());
		
			}
		});
		return null;
	}

}
