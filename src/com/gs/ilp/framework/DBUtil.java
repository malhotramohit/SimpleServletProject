package com.gs.ilp.framework;

import java.sql.Connection;

public class DBUtil {

	public static Connection getConnection() {
		return DBManagerForMySql.getConnection();
	}

}
