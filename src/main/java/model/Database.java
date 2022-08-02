package model;

import java.net.URI;

public class Database {
	private static URI dbUri = new URI(System.getenv("DATABASE_URL"));

	private static String DB_USER = dbUri.getUserInfo().split(":")[0];
	private static String DB_PASS = dbUri.getUserInfo().split(":")[1];
	private static String JDBC_URL = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    
	public static String getJDBC_URL() {
		return JDBC_URL;
	}

	public static String getDB_USER() {
		return DB_USER;
	}

	public static String getDB_PASS() {
		return DB_PASS;
	}

	public static final int maxExp = 19531250;
	public static final int maxLv = 250;
}
