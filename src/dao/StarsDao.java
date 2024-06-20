package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Stars;

public class StarsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Stars> select(Stars stars) {
		Connection conn = null;
		List<Stars> starsList = new ArrayList<Stars>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT U.user_id,C.id AS contribution_id,U.user_name,U.icon,C.pic_movie, S.user_id AS star "
					+ " FROM USERS AS U INNER JOIN CONTRIBUTIONS AS C ON U.user_id = C.user_id "
					+ " LEFT OUTER JOIN STARS AS S ON C.ID = S.CONTRIBUTION_ID "
					+ " WHERE S.user_id= ? ";


			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (stars.getUser_id() != null) {
				pStmt.setString(1,stars.getUser_id());
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Stars record = new Stars(
				rs.getInt ("id"),
				rs.getInt ("contribution_id"),
				rs.getString ("user_id"),
				rs.getTimestamp ("created_at"),
				rs.getTimestamp ("updated_at")
				);
				starsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			starsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			starsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					starsList = null;
				}
			}
		}

		// 結果を返す
		return starsList;
	}
}
