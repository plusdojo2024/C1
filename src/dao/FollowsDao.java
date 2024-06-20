package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Follows;

public class FollowsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Follows> select(Follows follows) {
		Connection conn = null;
		List<Follows> followsList = new ArrayList<Follows>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT F.follow_user_id, U.user_name, U.icon, F.user_id\r\n"
					+ "FROM USERS U INNER JOIN (SELECT user_id, follow_user_id FROM FOLLOWS WHERE user_id = ?) F\r\n"
					+ "ON U.user_id = F.follow_user_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (follows.getUser_id() != null) {
				pStmt.setString(1, follows.getUser_id());
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Follows record = new Follows(

				rs.getString("follow_user_id"),
				rs.getString("user_name"),
				rs.getString("icon"),
				rs.getString("user_id")

				);
				followsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			followsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			followsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					followsList = null;
				}
			}
		}

		// 結果を返す
		return followsList;
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
			String sql = "DELETE FROM FOLLOWS WHERE ID=?";
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

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Follows follows) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO  FOLLOWS VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (follows.getUser_id() != null && !follows.getUser_id().equals("")) {
					pStmt.setString(1, follows.getUser_id());
				}
				else {
					pStmt.setString(1, "（未設定）");
				}
				if (follows.getFollow_user_id() != null && !follows.getFollow_user_id().equals("")) {
					pStmt.setString(2, follows.getFollow_user_id());
				}
				else {
					pStmt.setString(2, "（未設定）");
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
}

