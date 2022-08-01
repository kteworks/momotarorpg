package model;

public class Database {
	private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/RPGDB";
	private static final String DB_USER = "sa";
	private static final String DB_PASS = "";

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

//	public static void main(String[] args) {
//		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
//				Database.getDB_PASS())) {
//			long totalexp = (125 * (100 * 100 * 100) / 100);
//			for (long i = 101; i <= 250; i++) {
//				String sql = "insert into exp_table values ("+i+"," + ((125 * (i * i * i) / 100) - totalexp) + ","
//						+ (125 * (i * i * i) / 100) + ");";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//				pStmt.execute();
//				totalexp = (125 * (i * i * i) / 100);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
