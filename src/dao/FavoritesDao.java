package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Favorites;

public class FavoritesDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Favorites> select(Favorites favorites) {
		Connection conn = null;
		List<Favorites> favoritesList = new ArrayList<Favorites>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT rikishies.id, rikishies.pic, rikishies.rikishi_name, rikishies.rikishi_profile FROM rikishies INNER JOIN favorites ON RIKISHIES.ID = FAVORITES.RIKISHI_ID WHERE FAVORITES.USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (favorites.getUser_id() != null) {
				pStmt.setString(1, "%" + favorites.getUser_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Favorites record = new Favorites(
				rs.getInt("id"),
				rs.getString("user_id"),
				rs.getInt("rikishi_id"),
				rs.getTimestamp("created_at"),
				rs.getTimestamp("updated_at")
				);
				favoritesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			favoritesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			favoritesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					favoritesList = null;
				}
			}
		}

		// 結果を返す
		return favoritesList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Favorites favorites) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO FAVORITES VALUES (NULL,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (favorites.getUser_id() != null && !favorites.getUser_id().equals("")) {
				pStmt.setString(1, favorites.getUser_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (favorites.getRikishi_id() != 0) {
				pStmt.setInt(2, favorites.getRikishi_id());
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM FAVORITES WHERE id= ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, number);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}