package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

public interface UsersBusinessServiceInterface {

		public void test();
		public List<UserModel> getUsers();
		public UserModel getByID(int id);
		public List<UserModel> searchUsers(String searchTerm);
		public int addOne(UserModel newUser);
		public boolean deleteOne(int id);
		public UserModel updateOne(int idToUpdate, UserModel updateOrder);
		public void init();
		public void destroy();
}
