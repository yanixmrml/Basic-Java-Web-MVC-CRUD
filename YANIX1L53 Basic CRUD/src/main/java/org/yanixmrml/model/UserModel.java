package org.yanixmrml.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.yanixmrml.entity.User;

public class UserModel {

	public UserModel() {
		super();
	}

	public List<User> getUserList(DataSource dataSource) throws SQLException{
		List<User> userList = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				userList.add(new User(rs.getInt("userID"),rs.getString("username"),rs.getString("password"),
						rs.getString("lastname"),rs.getString("firstname"),rs.getString("middlename")));
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			statement.close();
		}
		return userList;
	}
	
	public User getUser(DataSource dataSource, int userID) throws SQLException{
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement("SELECT * FROM users u WHERE u.userID = ?");
			pStatement.setInt(1, userID);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				return new User(rs.getInt("userID"),rs.getString("username"),rs.getString("password"),
						rs.getString("lastname"),rs.getString("firstname"),rs.getString("middlename"));
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			pStatement.close();
		}
		return null;
	}
	
	
	public boolean addUser(DataSource dataSource, User user) throws SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		String sql = "INSERT INTO users(username,password,lastname,firstname,middlename) VALUES(?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getUsername());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getLastname());
			pStatement.setString(4, user.getFirstname());
			pStatement.setString(5, user.getMiddlename());
			return pStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			pStatement.close();
		}
		return false;
	}
	
	public boolean updateUser(DataSource dataSource, User user) throws SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		String sql = "UPDATE users SET username = ?,password = ?,lastname = ?,firstname = ?,middlename = ? WHERE userID = ?";
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getUsername());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getLastname());
			pStatement.setString(4, user.getFirstname());
			pStatement.setString(5, user.getMiddlename());
			pStatement.setInt(6, user.getUserID());
			return pStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			pStatement.close();
		}
		return false;
	}
	
	public boolean deleteUser(DataSource dataSource, int userID) throws SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null;
		String sql = "DELETE FROM users WHERE userID = ?";
		try {
			connection = dataSource.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, userID);
			return pStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			pStatement.close();
		}
		return false;
	}
	
}
