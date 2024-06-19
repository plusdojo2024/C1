package model;

import java.sql.Timestamp;

public class Follows {
	//フィールド
		private int id;
		private String user_id;
		private String follow_user_id;
		private Timestamp created_at;
		private Timestamp updated_at;

	//コンストラクタ
		public Follows(int id, String user_id, String follow_user_id, Timestamp created_at, Timestamp updated_at) {
			this.id = id;
			this.user_id = user_id;
			this.follow_user_id = follow_user_id;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}

	// デフォルトコンストラクタ
		public Follows() {

		}

    //ゲッターとセッター
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

		public String getFollow_user_id() {
			return follow_user_id;
		}

		public void setFollow_user_id(String follow_user_id) {
			this.follow_user_id = follow_user_id;
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
