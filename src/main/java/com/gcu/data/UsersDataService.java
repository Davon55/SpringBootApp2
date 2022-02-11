package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.UserModel;
import com.gcu.model.UsersMapper;

//@Component is a generic stereotype for any spring spring- managed commponent
//@Service annotates classes at the service layer
//@Repository annotates classes at the persistence layer, this acts as the database
@Repository
public class UsersDataService implements UsersDataAccessInterface<UserModel> {

	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public UsersDataService(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public UserModel getByID(int id) {
		UserModel result = jdbcTemplate.queryForObject(
				"SELECT * FROM users WHERE ID = ?", new UsersMapper(), new Object[] {id});
		return result;
	}
	@Override
	public List<UserModel> getUsers() {
		return jdbcTemplate.query(
				"SELECT * FROM users", new UsersMapper());
	}
	@Override
	public List<UserModel> searchUsers(String searchTerm) {
		
		return jdbcTemplate.query(
				"SELECT * FROM users WHERE FIRST_NAME LIKE ?", new UsersMapper(), new Object[] {"%" + searchTerm + "%"});
	}
	@Override
	public int addOne(UserModel newUser) {
		return jdbcTemplate.update(
				"insert into users (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, EMAIL) values (?,?,?,?,?)",
				newUser.getFirstname(),
				newUser.getLastname(),
				newUser.getUsername(),
				newUser.getPassword(),
				newUser.getEmail());
	}
	@Override
	public boolean deleteOne(int id) {
		int updateResult = jdbcTemplate.update(
				"delete from users where id = ?",
				new Object[] {id});
		return (updateResult > 0);
	}
	@Override
	public UserModel updateOne(int idToUpdate, UserModel updateUser) {
		int result = jdbcTemplate.update(
				"update users set FIRST_NAME = ?, LAST_NAME = ?, USERNAME = ?, PASSWORD = ?, EMAIL = ? where id = ?",
				updateUser.getFirstname(),
				updateUser.getLastname(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				updateUser.getEmail());
		if(result > 0) {
			return updateUser;
		}
		else {
			return null;
		}
				
	}
	
	
	
}
