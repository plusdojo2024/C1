package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contributions;

public class ContributionsDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Contributions> select(Contributions contributions) {
		Connection conn = null;
		List<Contributions> contributionsList = new ArrayList<Contributions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT contributions.id, contributions.user_id, contributions.pic_movie "
					+ "FROM rikishies INNER JOIN contributions "
					+ "ON rikishies.id = contributions.rikishi_id "
					+ "WHERE rikishies.id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getRikishi_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//rs.next()で、最初は最初の1行をさしtrueを返す
			//次からは、次の1行があればtrueを返し、その行を指す
			//次の行がないとfalseとなり、while文は終了で次に進む
			while (rs.next()) {
				Contributions record = new Contributions(
				rs.getInt("id"),
				rs.getString("user_id"),
				rs.getString("pic_movie")
				);
				contributionsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			contributionsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			contributionsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					contributionsList = null;
				}
			}
		}

		// 結果を返す
		return contributionsList;
	}

	// 返信ページで、１つの投稿を白星込みで表示する１つのレコードを返す
	public List<Contributions> selectReplyContribution(Contributions contributions) {
		Connection conn = null;
		List<Contributions> contributionsList = new ArrayList<Contributions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT C.user_id, C.rikishi_id, C.id, U.icon,U.user_name, C.pic_movie, C.text, S.user_id star "
					+ "FROM (SELECT * FROM CONTRIBUTIONS WHERE id = ?) AS C "
					+ "LEFT JOIN USERS U "
					+ "ON U.user_id = C.user_id "
					+ "LEFT JOIN (SELECT * FROM STARS WHERE user_id = ?) AS S "
					+ "ON C.ID = S.CONTRIBUTION_ID";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());
			pStmt.setString(2, contributions.getStars_user_id());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//rs.next()で、最初は最初の1行をさしtrueを返す
			//次からは、次の1行があればtrueを返し、その行を指す
			//次の行がないとfalseとなり、while文は終了で次に進む
			while (rs.next()) {
				Contributions record = new Contributions(
				rs.getString("user_id"),
				rs.getInt("rikishi_id"),
				rs.getInt("id"),
				rs.getString("icon"),
				rs.getString("user_name"),
				rs.getString("pic_movie"),
				rs.getString("text"),
				rs.getString("star")
				);
				contributionsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			contributionsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			contributionsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					contributionsList = null;
				}
			}
		}

		// 結果を返す
		return contributionsList;
	}


}
