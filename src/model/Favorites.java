package model;

import java.sql.Timestamp;

public class Favorites {
	// フィールド
    private int id;
    private String user_id;
    private int rikishi_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    // コンストラクタ
	public Favorites(int id, String user_id, int rikishi_id, Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.rikishi_id = rikishi_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



	//テスト用
	public Favorites(String user_id, int rikishi_id) {
		this.user_id = user_id;
		this.rikishi_id = rikishi_id;
	}


	// デフォルトコンストラクタ
		public Favorites() {

		}

	// ゲッターとセッター

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public int getRikishi_id() {
			return rikishi_id;
		}

		public void setRikishi_id(int rikishi_id) {
			this.rikishi_id = rikishi_id;
		}

		public Timestamp getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Timestamp created_at) {
			this.created_at = created_at;
		}

		public Timestamp getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Timestamp updated_at) {
			this.updated_at = updated_at;
		}

}
