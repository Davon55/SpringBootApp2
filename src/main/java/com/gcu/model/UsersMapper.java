package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class UsersMapper implements RowMapper<UserModel>{

	
	//matches the property names in OrderModel with the column name sin the database
	
	
	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel  users = new UserModel (
				rs.getInt("ID"),
				rs.getString("FIRST_NAME"),
				rs.getString("LAST_NAME"),
				rs.getString("USERNAME"),
				rs.getString("PASSWORD"),
				rs.getString("EMAIL")
				);
		return users;
	}

}
