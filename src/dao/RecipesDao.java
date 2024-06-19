package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Recipes;

public class RecipesDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Recipes> select(Recipes Recipe) {
		Connection conn = null;
		List<Recipes> Recipelist = new ArrayList<Recipes>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT RECIPES.ID, RECIPES.RIKISHI_ID, RECIPES.CATEGORY, RECIPES.RECIPE_PIC, RECIPES.RECIPI_NAME, RECIPES.RECIPI_LINK, RIKISHIES.RIKISHI_NAME, RIKISHIES.SUMO_STABLE_NAME FROM RECIPES INNER JOIN RIKISHIES ON RECIPES.RIKISHI_ID = RIKISHIES.id WHERE RIKISHIES.RIKISHI_NAME LIKE ? AND RIKISHIES.SUMO_STABLE_NAME LIKE ? AND RECIPES.CATEGORY LIKE ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (Recipe.getRikishi_name() != null) {
				pStmt.setString(1, "%" + Recipe.getRikishi_name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (Recipe.getSumo_stable_name() != null) {
				pStmt.setString(2, "%" + Recipe.getSumo_stable_name() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (Recipe.getCategory() != null) {
				pStmt.setString(3, "%" + Recipe.getCategory() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Recipes record = new Recipes(
				Recipe.getRikishi_name(),
				Recipe.getSumo_stable_name(),
				Recipe.getCategory(),
				rs.getInt("id"),
				rs.getInt("rikishi_id"),
				rs.getString("recipe_pic"),
				rs.getString("recipe_name"),
				rs.getString("recipe_link")
				);
				Recipe.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Recipelist = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Recipelist = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Recipelist = null;
				}
			}
		}

		// 結果を返す
		return Recipelist;
	}
