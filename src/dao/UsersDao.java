package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class UsersDao {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM USERS WHERE user_id = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, users.getUser_id());
			pStmt.setString(2,users.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}



	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Users> select(Users users) {
		Connection conn = null;
		List<Users> usersList = new ArrayList<Users>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する（マイページの初期表示のために情報を取得　　ユーザプロフィールを取得したユーザIDで検索）
			String sql = "SELECT users.user_id , users.user_name, users.icon, users.message, favorites.rikishi_id, RIKISHIES.pic, RIKISHIES.RIKISHI_NAME"
					+ " FROM users"
					+ " INNER JOIN favorites"
					+ " ON users.user_id = favorites.user_id"
					+ " INNER JOIN RIKISHIES"
					+ " ON favorites.rikishi_id = RIKISHIES.id"
					+ " WHERE users.user_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, users.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//re.next()で
			while (rs.next()) {
				Users record = new Users(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getString("icon"),
						rs.getString("message"),
						rs.getString("ask"),
						rs.getString("question"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"));
				usersList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			usersList = null;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			usersList = null;

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					usersList = null;
				}
			}
		}

		// 結果を返す
		return usersList;
	}

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Users> select(Users users) {
		Connection conn = null;
		List<Users> usersList = new ArrayList<Users>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する（他人のマイページの初期表示のために情報を取得　　followの有無がある）
			String sql = "SELECT U.user_id , U.user_name, U.icon, U.message, F.rikishi_id, R.pic, R.rikishi_name, FU.user_id FOLLOW "
					+ " FROM USERS U LEFT JOIN (SELECT user_id, follow_user_id FROM FOLLOWS WHERE user_id = ?) FU"
					+ " ON U.user_id = FU.follow_user_id"
					+ " INNER JOIN FAVORITES F"
					+ " ON U.user_id = F.user_id"
					+ " INNER JOIN RIKISHIES R"
					+ " ON F.rikishi_id = R.id"
					+ " WHERE U.user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, users.getUser_id());
			pStmt.setString(2, users.getUser_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//re.next()で
			while (rs.next()) {
				Users record = new Users(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getString("icon"),
						rs.getString("message"),
						rs.getString("ask"),
						rs.getString("question"),
						rs.getTimestamp("created_at"),
						rs.getTimestamp("updated_at"));
				usersList.add(record);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			usersList = null;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			usersList = null;

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					usersList = null;
				}
			}
		}

		// 結果を返す
		return usersList;
	}

}