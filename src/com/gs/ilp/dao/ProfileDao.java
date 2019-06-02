package com.gs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gs.ilp.framework.CustomException;
import com.gs.ilp.framework.DBUtil;
import com.gs.ilp.model.ProfileModel;

public class ProfileDao {

	public ProfileModel getProfileByUnameAndPswd(String username, String password) {
		ProfileModel profileModel = new ProfileModel();
		try {
			String query = "select * from profile where username = ? and password =?";
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				profileModel.setSeq(resultSet.getInt(1));
				profileModel.setUsername(resultSet.getString(2));
				profileModel.setPassword(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profileModel;

	}

	public void save(ProfileModel profileModel) throws CustomException {

		String query = "insert into profile values (? ,?,?)";
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, profileModel.getSeq());
			preparedStatement.setString(2, profileModel.getUsername());
			preparedStatement.setString(3, profileModel.getPassword());
			int i =preparedStatement.executeUpdate();
			System.out.println("inserted "+i);
		} catch (SQLException e) {
			throw new CustomException("Something went wrong", e);
		}

	}

}
