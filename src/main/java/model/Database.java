package model;

import java.net.URI;
import java.net.URISyntaxException;

public class Database {
	private static URI dbUri;

	private static String DB_USER = getDbUri().getUserInfo().split(":")[0];
	private static String DB_PASS = getDbUri().getUserInfo().split(":")[1];
	private static String JDBC_URL = "jdbc:postgresql://" + getDbUri().getHost() + ':' + getDbUri().getPort() + getDbUri().getPath()  + "?sslmode=require";
    
	public static URI getDbUri() {
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return dbUri;
  	}
	
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
