package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.BuyItem;
import model.Database;
import model.ShopitemList;
import model.Sync;

public class ShopitemListDAO {

	private final String JDBC_URL = Database.getJDBC_URL();
	private final String DB_USER = Database.getDB_USER();
	private final String DB_PASS = Database.getDB_PASS();

	public ShopitemList getShopitemList() {

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sq1 = "SELECT * from SHOP_ITEMLIST";
			PreparedStatement pStmt = conn.prepareStatement(sq1);

			ResultSet rs = pStmt.executeQuery();

			List<String>[] arrayList = new ArrayList[2];

			while (rs.next()) {
				arrayList[0].add(rs.getString("item_name"));
				arrayList[1].add(rs.getString("price"));
			}
			ShopitemList shopItemList = new ShopitemList();
			shopItemList.setShopitemList(arrayList);
			return shopItemList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean OrderItem(Account account, String buyitem_id) {

		int item_id = Integer.parseInt(buyitem_id);

		// BuyItemの作成
		BuyItem buyitem = new BuyItem(buyitem_id);
		try (Connection conn = DriverManager.getConnection(Database.getJDBC_URL(), Database.getDB_USER(),
				Database.getDB_PASS())) {

			String sql = "SELECT ITEM_NAME,PRICE FROM SHOP_ITEMLIST WHERE ITEM_ID = " + buyitem_id;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("ITEM_NAME");
				int price = rs.getInt("PRICE");
				buyitem.setItemName(name);
				buyitem.setPrice(price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 所持金が足りるかどうか
		if (account.getMoney() - buyitem.getPrice() < 0) {
			return false;
		}

		// 所時数オーバー確認
		int[] inv = account.getItem();
		if (inv[item_id] == 3) {
			return false;
		}

		int money = account.getMoney() - buyitem.getPrice();
		account.setMoney(money);
		Sync sync = new Sync();
		sync.moneySync(account);

		inv[buyitem.getItem_id()] += 1;
		account.setItem(inv);
		sync.itemSync(account);

		return true;
	}

}
