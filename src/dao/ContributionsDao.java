package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.Contributions;

public class ContributionsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Contributions> select(Contributions data) {
		Connection conn = null;
		List<Contributions> dataList = new ArrayList<Contributions>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/C1", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM Bc WHERE company LIKE ? AND c_furigana LIKE ? AND department LIKE ? "
					+ "AND position LIKE ? AND last_name LIKE ? AND first_name LIKE ? AND ln_furigana LIKE ? "
					+ "AND fn_furigana LIKE ? AND zipcode LIKE ? AND address LIKE ? AND phone LIKE ? "
					+ "AND fax LIKE ? AND email LIKE ? AND remarks LIKE ? AND regist_date LIKE ? "
					+ "AND update_date LIKE ? AND id = ? ORDER BY ";
			if (Objects.nonNull(card.getSort())) {
				sql += card.getSort() + " " + card.getOrder();
			}
			else {
				sql += "number";
			}
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null) {
				pStmt.setString(1, "%" + card.getCompany() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (card.getC_furigana() != null) {
				pStmt.setString(2, "%" + card.getC_furigana() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (card.getDepartment() != null) {
				pStmt.setString(3, "%" + card.getDepartment() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (card.getPosition() != null) {
				pStmt.setString(4, "%" + card.getPosition() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (card.getLast_name() != null) {
				pStmt.setString(5, "%" + card.getLast_name() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (card.getFirst_name() != null) {
				pStmt.setString(6, "%" + card.getFirst_name() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}
			if (card.getLn_furigana() != null) {
				pStmt.setString(7, "%" + card.getLn_furigana() + "%");
			}
			else {
				pStmt.setString(7, "%");
			}
			if (card.getFn_furigana() != null) {
				pStmt.setString(8, "%" + card.getFn_furigana() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}
			if (card.getZipcode() != null) {
				pStmt.setString(9, "%" + card.getZipcode() + "%");
			}
			else {
				pStmt.setString(9, "%");
			}
			if (card.getAddress() != null) {
				pStmt.setString(10, "%" + card.getAddress() + "%");
			}
			else {
				pStmt.setString(10, "%");
			}
			if (card.getPhone() != null) {
				pStmt.setString(11, "%" + card.getPhone() + "%");
			}
			else {
				pStmt.setString(11, "%");
			}
			if (card.getFax() != null) {
				pStmt.setString(12, "%" + card.getFax() + "%");
			}
			else {
				pStmt.setString(12, "%");
			}
			if (card.getEmail() != null) {
				pStmt.setString(13, "%" + card.getEmail() + "%");
			}
			else {
				pStmt.setString(13, "%");
			}
			if (card.getRemarks() != null) {
				pStmt.setString(14, "%" + card.getRemarks() + "%");
			}
			else {
				pStmt.setString(14, "%");
			}
			if (card.getDate() != null) {
				pStmt.setString(15, "%" + card.getRegist_date() + "%");
			}
			else {
				pStmt.setString(15, "%");
			}
			if (card.getDate() != null) {
				pStmt.setString(16, "%" + card.getUpdate_date() + "%");
			}
			else {
				pStmt.setString(16, "%");
			}
			pStmt.setString(17, card.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//rs.next()で、最初は最初の1行をさしtrueを返す
			//次からは、次の1行があればtrueを返し、その行を指す
			//次の行がないとfalseとなり、while文は終了で次に進む
			while (rs.next()) {
				Bc record = new Bc(
				rs.getInt("number"),
				rs.getString("company"),
				rs.getString("c_furigana"),
				rs.getString("department"),
				rs.getString("position"),
				rs.getString("last_name"),
				rs.getString("first_name"),
				rs.getString("ln_furigana"),
				rs.getString("fn_furigana"),
				rs.getString("zipcode"),
				rs.getString("address"),
				rs.getString("phone"),
				rs.getString("fax"),
				rs.getString("email"),
				rs.getString("remarks"),
				rs.getString("regist_date"),
				rs.getString("update_date"),
				rs.getString("id")
				);
				cardList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Bc VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(1, card.getCompany());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			if (card.getC_furigana() != null && !card.getC_furigana().equals("")) {
				pStmt.setString(2, card.getC_furigana());
			}
			else {
				pStmt.setString(2, "（未設定）");
			}
			if (card.getDepartment() != null && !card.getDepartment().equals("")) {
				pStmt.setString(3, card.getDepartment());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			if (card.getPosition() != null && !card.getPosition().equals("")) {
				pStmt.setString(4, card.getPosition());
			}
			else {
				pStmt.setString(4, "（未設定）");
			}
			if (card.getLast_name() != null && !card.getLast_name().equals("")) {
				pStmt.setString(5, card.getLast_name());
			}
			else {
				pStmt.setString(5, "（未設定）");
			}
			if (card.getFirst_name() != null && !card.getFirst_name().equals("")) {
				pStmt.setString(6, card.getFirst_name());
			}
			else {
				pStmt.setString(6, "（未設定）");
			}
			if (card.getLn_furigana() != null && !card.getLn_furigana().equals("")) {
				pStmt.setString(7, card.getLn_furigana());
			}
			else {
				pStmt.setString(7, "（未設定）");
			}
			if (card.getFn_furigana() != null && !card.getFn_furigana().equals("")) {
				pStmt.setString(8, card.getFn_furigana());
			}
			else {
				pStmt.setString(8, "（未設定）");
			}
			if (card.getZipcode() != null && !card.getZipcode().equals("")) {
				pStmt.setString(9, card.getZipcode());
			}
			else {
				pStmt.setString(9, "（未設定）");
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(10, card.getAddress());
			}
			else {
				pStmt.setString(10, "（未設定）");
			}
			if (card.getPhone() != null && !card.getPhone().equals("")) {
				pStmt.setString(11, card.getPhone());
			}
			else {
				pStmt.setString(11, "（未設定）");
			}
			if (card.getFax() != null && !card.getFax().equals("")) {
				pStmt.setString(12, card.getFax());
			}
			else {
				pStmt.setString(12, "（未設定）");
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(13, card.getEmail());
			}
			else {
				pStmt.setString(13, "（未設定）");
			}
			if (card.getRemarks() != null && !card.getRemarks().equals("")) {
				pStmt.setString(14, card.getRemarks());
			}
			else {
				pStmt.setString(14, "（未設定）");
			}
			pStmt.setString(15, card.getDate());
			pStmt.setString(16, "更新無し");
			pStmt.setString(17, card.getId());

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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Bc SET company=?, c_furigana=?, department=?, position=?, last_name=?, "
					+ "first_name=?, ln_furigana=?, fn_furigana=?, zipcode=?, address=?, phone=?, fax=?, "
					+ "email=?, remarks=?, update_date=? WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getCompany() != null && !card.getCompany().equals("")) {
				pStmt.setString(1, card.getCompany());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getC_furigana() != null && !card.getC_furigana().equals("")) {
				pStmt.setString(2, card.getC_furigana());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getDepartment() != null && !card.getDepartment().equals("")) {
				pStmt.setString(3, card.getDepartment());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getPosition() != null && !card.getPosition().equals("")) {
				pStmt.setString(4, card.getPosition());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getLast_name() != null && !card.getLast_name().equals("")) {
				pStmt.setString(5, card.getLast_name());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getFirst_name() != null && !card.getFirst_name().equals("")) {
				pStmt.setString(6, card.getFirst_name());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getLn_furigana() != null && !card.getLn_furigana().equals("")) {
				pStmt.setString(7, card.getLn_furigana());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getFn_furigana() != null && !card.getFn_furigana().equals("")) {
				pStmt.setString(8, card.getFn_furigana());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getZipcode() != null && !card.getZipcode().equals("")) {
				pStmt.setString(9, card.getZipcode());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(10, card.getAddress());
			}
			else {
				pStmt.setString(10, null);
			}
			if (card.getPhone() != null && !card.getPhone().equals("")) {
				pStmt.setString(11, card.getPhone());
			}
			else {
				pStmt.setString(11, null);
			}
			if (card.getFax() != null && !card.getFax().equals("")) {
				pStmt.setString(12, card.getFax());
			}
			else {
				pStmt.setString(12, null);
			}
			if (card.getEmail() != null && !card.getEmail().equals("")) {
				pStmt.setString(13, card.getEmail());
			}
			else {
				pStmt.setString(13, null);
			}
			if (card.getRemarks() != null && !card.getRemarks().equals("")) {
				pStmt.setString(14, card.getRemarks());
			}
			else {
				pStmt.setString(14, null);
			}
			pStmt.setString(15, card.getDate());
			pStmt.setInt(16, card.getNumber());

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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM Bc WHERE number=?";
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
