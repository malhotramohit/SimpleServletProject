package com.gs.ilp.framework;

import java.sql.Connection;

public class TestDBConnection {

	public static void main(String[] args) {
		Connection connection = DBManagerForMySql.getConnection();
		System.out.println(connection);
	}
}
