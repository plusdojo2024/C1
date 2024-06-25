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

	// 返信ページで、その投稿に対する返信を表示するリストを返す
	public List<Contributions> selectReply(Contributions contributions) {
		Connection conn = null;
		List<Contributions> contributionsList = new ArrayList<Contributions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT R.*, U.user_name FROM (SELECT * FROM REPLIES WHERE contribution_id = ?) AS R "
					+ "INNER JOIN USERS AS U "
					+ "ON R.user_id = U.user_id "
					+ "ORDER BY id DESC";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//rs.next()で、最初は最初の1行をさしtrueを返す
			//次からは、次の1行があればtrueを返し、その行を指す
			//次の行がないとfalseとなり、while文は終了で次に進む
			while (rs.next()) {
				Contributions record = new Contributions(
				rs.getString("user_id"),
				rs.getString("user_name"),
				rs.getString("text")
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

	// 返信ページで、その投稿に対する返信をINSERTする処理
	public boolean insertReply(Contributions contributions) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO  REPLIES VALUES (NULL,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());
			pStmt.setString(2, contributions.getUser_id());
			pStmt.setString(3, contributions.getText());

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

	// 返信ページで、投稿に白星をつける処理
	public boolean insertStar(Contributions contributions) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO  STARS VALUES (NULL,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());
			pStmt.setString(2, contributions.getStars_user_id());

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

	// 返信ページで、その投稿に対する白星リストを返す（テスト用）
	public List<Contributions> selectStar(Contributions contributions) {
		Connection conn = null;
		List<Contributions> contributionsList = new ArrayList<Contributions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM STARS WHERE contribution_id = ? ORDER BY id DESC";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//rs.next()で、最初は最初の1行をさしtrueを返す
			//次からは、次の1行があればtrueを返し、その行を指す
			//次の行がないとfalseとなり、while文は終了で次に進む
			while (rs.next()) {
				Contributions record = new Contributions(
				rs.getInt("id"),
				rs.getInt("contribution_id"),
				rs.getString("user_id"),
				rs.getTimestamp("created_at"),
				rs.getTimestamp("updated_at")
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

	// 白星IDで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(Contributions contributions) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM STARS WHERE contribution_id = ? "
					+ "AND user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, contributions.getId());
			pStmt.setString(2, contributions.getStars_user_id());

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

	// マイページ
		public List<Contributions> select2(Contributions contributions) {
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
						+ "WHERE contributions.user_id = ?";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, contributions.getUser_id());

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

		// マイページ
				public boolean insert(Contributions contributions) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

						// SQL文を準備する
						String sql = "INSERT INTO CONTRIBUTIONS (NULL, ?, ?, /img + ?,  ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setString(1, contributions.getUser_id());
						pStmt.setInt(2, contributions.getRikishi_id());
						pStmt.setString(3, contributions.getPic_movie());
						pStmt.setString(4, contributions.getText());

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
