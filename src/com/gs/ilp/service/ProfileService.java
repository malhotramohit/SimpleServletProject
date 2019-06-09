package com.gs.ilp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gs.ilp.dao.ProfileDao;
import com.gs.ilp.framework.CustomException;
import com.gs.ilp.framework.DBUtil;
import com.gs.ilp.model.ProfileModel;

public class ProfileService {

	private ProfileDao profileDao = new ProfileDao();

	public ProfileService() {

	}

	// public boolean doAuthentication(String username, String password) {
	// boolean flag = false;
	// ProfileDao profileDao = new ProfileDao();
	// ProfileModel profileFromDb = profileDao.getProfileByUnameAndPswd(username,
	// password);
	// if (username.equals(profileFromDb.getUsername()) &&
	// password.equals(profileFromDb.getPassword())) {
	// flag = true;
	// }
	//
	// return flag;
	// }
	//
	// public void save(String uname, String pswd) throws CustomException {
	// ProfileModel profileModel = new ProfileModel();
	// profileModel.setSeq(2);
	// profileModel.setUsername(uname);
	// profileModel.setPassword(pswd);
	// ProfileDao profileDao = new ProfileDao();
	// profileDao.save(profileModel);
	//
	// }

	public void saveProfile(ProfileModel profileModel) throws CustomException {

		profileDao.saveProfile(profileModel);
	}

	public List<ProfileModel> getAllProfiles() throws CustomException {
		return profileDao.getAllProfiles();
	}
	public int deleteProfile(Long seq) throws CustomException {
		return profileDao.deleteProfile(seq);
	}

}
