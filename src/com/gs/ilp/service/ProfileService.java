package com.gs.ilp.service;

import com.gs.ilp.dao.ProfileDao;
import com.gs.ilp.framework.CustomException;
import com.gs.ilp.model.ProfileModel;

public class ProfileService {

	static ProfileService _instance;

	public static synchronized ProfileService getInstance() {
		if (null == _instance) {
			_instance = new ProfileService();
		}
		return _instance;
	}

	private ProfileService() {

	}

	public boolean doAuthentication(String username, String password) {
		boolean flag = false;
		ProfileDao profileDao = new ProfileDao();
		ProfileModel profileFromDb = profileDao.getProfileByUnameAndPswd(username, password);
		if (username.equals(profileFromDb.getUsername()) && password.equals(profileFromDb.getPassword())) {
			flag = true;
		}

		return flag;
	}

	public void save(String uname, String pswd) throws CustomException {
		ProfileModel profileModel = new ProfileModel();
		profileModel.setSeq(2);
		profileModel.setUsername(uname);
		profileModel.setPassword(pswd);
		ProfileDao profileDao = new  ProfileDao();
		profileDao.save(profileModel);
		
	}

}
