package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Stores;

public class StoresDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Stores> select(Stores stores) {
		Connection conn = null;
		List<Stores> storesList = new ArrayList<Stores>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT venue_name, shop_pic, food_pic, shop_name, shop_link "
					+ " FROM STORES "
					+ " WHERE venue_name = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (stores.getVenue_name() != null) {
				pStmt.setString(1,stores.getVenue_name());
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Stores record = new Stores(
				rs.getInt("id"),
				rs.getString("shop_name"),
				rs.getString("shop_pic"),
				rs.getString("food_pic"),
				rs.getString("shop_link"),
				rs.getString("venue_name")
				);
				storesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			storesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			storesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					storesList = null;
				}
			}
		}

		// 結果を返す
		return storesList;
	}
}
