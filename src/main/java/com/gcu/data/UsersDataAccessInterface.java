package com.gcu.data;

import java.util.List;

import com.gcu.model.UserModel;

public interface UsersDataAccessInterface<T> {

	public T getByID(int id);
	public List<T> getUsers();
	public List<T> searchUsers(String searchTerm);
	public int addOne(T newUser);
	public boolean deleteOne(int id);
	public T updateOne(int idToUpdate, T updateOrder);
}
