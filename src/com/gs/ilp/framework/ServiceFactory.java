package com.gs.ilp.framework;

import com.gs.ilp.service.ProfileService;

public class ServiceFactory {

	public static Object getInstance(Class classParam) {

		Object instance = null;

		if (classParam.getName().equals("com.gs.ilp.service.ProfileService")) {

			instance = ProfileService.getInstance();

		}

		return instance;

	}

}
