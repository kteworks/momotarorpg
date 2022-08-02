package model;

import java.net.URI;
import java.net.URISyntaxException;

public class Database {
	private static final String HOST = "ec2-34-193-44-192.compute-1.amazonaws.com";
	private static final String DB_NAME = "de81jcg0ffo4th";
	private static final String PORT = "5432";
	private static final String DB_USER = "qmlxmlqaqlyauk";
	private static final String DB_PASS = "86de3290ea25ece6f7128b7b1b3ff277d284dbcb0403c20c51677b47063e1cc4";
	private static final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME;
	
	
//	private static URI dbUri;

//	private static String DB_USER = getDbUri().getUserInfo().split(":")[0];
//	private static String DB_PASS = getDbUri().getUserInfo().split(":")[1];
//	private static String JDBC_URL = "jdbc:postgresql://" + getDbUri().getHost() + ':' + getDbUri().getPort() + getDbUri().getPath();
    
//	public static URI getDbUri() {
//		try {
//			dbUri = new URI(System.getenv("DATABASE_URL"));
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//		return dbUri;
//	}
	
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
