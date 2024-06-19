package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model. Rikishies;

public class RikishiesDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す 16rikishiesは変数名なんでもいい
	public List<Rikishies> select(Rikishies rikishies) {
		Connection conn = null;
		List<Rikishies> rikishiesList = new ArrayList<Rikishies>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する 曖昧検索
			String sql = "SELECT rikishies.id, rikishies.pic, rikishies.rikishi_name, rikishies.rikishi_profile FROM rikishies WHERE rikishies.id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, rikishies.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Rikishies record = new Rikishies(
				rs.getInt("id"),
				rs.getString("pic"),
				rs.getString("rikishi_name"),
				rs.getString("sumo_association_link"),
				rs.getString("rikishi_profile"),
				rs.getString("calendar"),
				rs.getString("sumo_stable_name"),
				rs.getTimestamp("created_at"),
				rs.getTimestamp("update_at")
				);
				rikishiesList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			rikishiesList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			rikishiesList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					rikishiesList = null;
				}
			}
		}

		// 結果を返す
		return rikishiesList;
	}





}
