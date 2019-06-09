package com.gs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gs.ilp.framework.CustomException;
import com.gs.ilp.framework.DBUtil;
import com.gs.ilp.model.ProfileModel;

public class ProfileDao {

	public void saveProfile(ProfileModel profileModel) throws CustomException {
		//

		try {
			String sql = "insert into profile values (?,?,?,?,?)";
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, profileModel.getSeq());
			preparedStatement.setString(2, profileModel.getEmail());
			preparedStatement.setString(3, profileModel.getPassword());
			preparedStatement.setString(4, profileModel.getFirstName());
			preparedStatement.setString(5, profileModel.getLastName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("Something went wrong " + e.getMessage(), e);
		}
	}

	public List<ProfileModel> getAllProfiles() throws CustomException {
		List<ProfileModel> profileModels = new ArrayList<>();

		try {

			String sql = "select seq,email,firstname,lastname from profile";
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			ProfileModel profileModel;
			while (resultSet.next()) {
				profileModel = new ProfileModel();
				profileModel.setSeq(resultSet.getInt("seq"));
				profileModel.setEmail(resultSet.getString("email"));
				profileModel.setFirstName(resultSet.getString(3));
				profileModel.setLastName(resultSet.getString("lastname"));
				profileModels.add(profileModel);
			}

		} catch (SQLException exception) {
			throw new CustomException("Error while selecting profiles", exception);
		}
		return profileModels;
	}

	public int deleteProfile(Long seq) throws CustomException {
		int res = 0;

		try {

			String sql = "delete from profile where seq = ?";
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, seq);
			res = preparedStatement.executeUpdate();

		}

		catch (SQLException e) {
			throw new CustomException(e.getMessage(), e);
		}
		return res;

	}

	// public ProfileModel getProfileByUnameAndPswd(String username, String
	// password) {
	// ProfileModel profileModel = new ProfileModel();
	// try {
	// String query = "select * from profile where username = ? and password =?";
	// Connection connection = DBUtil.getConnection();
	// PreparedStatement preparedStatement = connection.prepareStatement(query);
	// preparedStatement.setString(1, username);
	// preparedStatement.setString(2, password);
	// ResultSet resultSet = preparedStatement.executeQuery();
	//
	// while (resultSet.next()) {
	// profileModel.setSeq(resultSet.getInt(1));
	// profileModel.setUsername(resultSet.getString(2));
	// profileModel.setPassword(resultSet.getString(3));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return profileModel;
	//
	// }
	//
	// public void save(ProfileModel profileModel) throws CustomException {
	//
	// String query = "insert into profile values (? ,?,?)";
	// Connection connection = DBUtil.getConnection();
	// try {
	// PreparedStatement preparedStatement = connection.prepareStatement(query);
	// preparedStatement.setInt(1, profileModel.getSeq());
	// preparedStatement.setString(2, profileModel.getUsername());
	// preparedStatement.setString(3, profileModel.getPassword());
	// int i =preparedStatement.executeUpdate();
	// System.out.println("inserted "+i);
	// } catch (SQLException e) {
	// throw new CustomException("Something went wrong", e);
	// }
	//
	// }

}
