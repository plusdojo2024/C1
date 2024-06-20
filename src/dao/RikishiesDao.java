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
	//力士の検索 テスト済み
	public List<Rikishies> select(Rikishies rikishies) {
		Connection conn = null;
		List<Rikishies> rikishiesList = new ArrayList<Rikishies>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する 力士のID検索
			String sql = "SELECT * FROM rikishies WHERE rikishies.id = ?";
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
				rs.getString("sumo_stable_name")
				//rs.getTimestamp("created_at"),
				//rs.getTimestamp("update_at")
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

	//待機部屋
		public List<Rikishies> select_StandBy(Rikishies rikishies) {
			Connection conn = null;
			List<Rikishies> rikishiesList = new ArrayList<Rikishies>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

				// SQL文を準備する 力士のID検索
				String sql = "SELECT rikishies.id, rikishies.pic, rikishies.rikishi_name, rikishies.SUMO_ASSOCIATION_LINK, FAVORITES.USER_ID FROM rikishies INNER JOIN favorites ON RIKISHIES.ID = FAVORITES.RIKISHI_ID WHERE FAVORITES.USER_ID = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, rikishies.getUser_id());

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Rikishies record = new Rikishies(
					rs.getInt("id"),
					rs.getString("pic"),
					rs.getString("rikishi_name"),
					rs.getString("sumo_association_link"),
					rs.getString("user_id")
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
		//力士一覧初期表示
				public List<Rikishies> select_rikishies(Rikishies rikishies) {
					Connection conn = null;
					List<Rikishies> rikishiesList = new ArrayList<Rikishies>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

						// SQL文を準備する 力士のID検索
						String sql = "SELECT R.pic, R.rikishi_name, R.sumo_association_link, F.user_id, R.id FROM RIKISHIES AS R  LEFT OUTER JOIN (SELECT * FROM FAVORITES WHERE user_id = ?) AS F ON R.id = F.rikishi_id GROUP BY rikishi_name";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setString(1, rikishies.getUser_id());

						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Rikishies record = new Rikishies(
							rs.getInt("id"),
							rs.getString("pic"),
							rs.getString("rikishi_name"),
							rs.getString("sumo_association_link"),
							rs.getString("user_id")
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
				//力士一覧の曖昧検索
				public List<Rikishies> select_rikishiesSearch(Rikishies rikishies) {
					Connection conn = null;
					List<Rikishies> rikishiesList = new ArrayList<Rikishies>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

						// SQL文を準備する 力士のID検索
						String sql = "SELECT R.pic, R.rikishi_name, R.sumo_association_link, F.user_id, R.id FROM RIKISHIES AS R  LEFT OUTER JOIN (SELECT * FROM FAVORITES WHERE user_id = ?) AS F ON R.id = F.rikishi_id GROUP BY rikishi_name HAVING rikishi_name LIKE ? OR sumo_stable_name LIKE ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setString(1, rikishies.getUser_id());
						pStmt.setString(2, "%" + rikishies.getRikishi_info() + "%");
						pStmt.setString(3, "%" + rikishies.getRikishi_info() + "%");
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Rikishies record = new Rikishies(
							rs.getInt("id"),
							rs.getString("pic"),
							rs.getString("rikishi_name"),
							rs.getString("sumo_association_link"),
							rs.getString("user_id")
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
