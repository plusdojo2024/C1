package model;
import java.io.Serializable;
import java.sql.Timestamp;


public class Rikishies implements Serializable {
	//フィールド
		private int id;							//力士ID
		private String pic;						//力士写真
		private String rikishi_name;			//力士名前
		private String sumo_association_link;	//相撲協会のURL
		private String rikishi_profile;			//力士プロフィール
		private String calendar;				//カレンダー
		private String sumo_stable_name;		//所属部屋
		private Timestamp created_at;			//
		private Timestamp update_at;			//
		private String user_id;   				//
		private String rikishi_info;			//力士名前と所属部屋で検索するためのフィールド


		//全部のコンストラクタ
		public Rikishies(int id, String pic, String rikishi_name, String sumo_association_link, String rikishi_profile,
				String calendar, String sumo_stable_name, Timestamp created_at, Timestamp update_at, String user_id, String rikishi_info) {
			this.id = id;
			this.pic = pic;
			this.rikishi_name = rikishi_name;
			this.sumo_association_link = sumo_association_link;
			this.rikishi_profile = rikishi_profile;
			this.calendar = calendar;
			this.sumo_stable_name = sumo_stable_name;
			this.created_at = created_at;
			this.update_at = update_at;
			this.user_id = user_id;
			this.rikishi_info = rikishi_info;
		}

		//力士の検索のコンストラクタ
				public Rikishies(int id, String pic, String rikishi_name, String sumo_association_link, String rikishi_profile,
						String calendar, String sumo_stable_name) {
					this.id = id;
					this.pic = pic;
					this.rikishi_name = rikishi_name;
					this.sumo_association_link = sumo_association_link;
					this.rikishi_profile = rikishi_profile;
					this.calendar = calendar;
					this.sumo_stable_name = sumo_stable_name;
					//this.created_at = created_at;
					//this.update_at = update_at;
				}

				//待機部屋のコンストラクタ、力士一覧初期表示のコンストラクタ、力士一覧の曖昧検索コンストラクタ
				public Rikishies(int id, String pic, String rikishi_name, String sumo_association_link,String user_id) {
					this.id = id;
					this.pic = pic;
					this.rikishi_name = rikishi_name;
					this.sumo_association_link = sumo_association_link;
					this.user_id = user_id;
				}


				//力士検索用コンストラクタ
				public Rikishies(int id) {
					this.id = id;
				}

				//力士検索用コンストラクタ
				public Rikishies(String user_id) {
					this.user_id = user_id;
				}
				//力士検索用コンストラクタ
				public Rikishies(String user_id, String rikishi_info) {
					this.user_id = user_id;
					this.rikishi_info = rikishi_info;
				}




		// デフォルトコンストラクタ
		public Rikishies() {

		}


		//getter,setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public String getRikishi_name() {
			return rikishi_name;
		}
		public void setRikishi_name(String rikishi_name) {
			this.rikishi_name = rikishi_name;
		}
		public String getSumo_association_link() {
			return sumo_association_link;
		}
		public void setSumo_association_link(String sumo_association_link) {
			this.sumo_association_link = sumo_association_link;
		}
		public String getRikishi_profile() {
			return rikishi_profile;
		}
		public void setRikishi_profile(String rikishi_profile) {
			this.rikishi_profile = rikishi_profile;
		}
		public String getCalendar() {
			return calendar;
		}
		public void setCalendar(String calendar) {
			this.calendar = calendar;
		}
		public String getSumo_stable_name() {
			return sumo_stable_name;
		}
		public void setSumo_stable_name(String sumo_stable_name) {
			this.sumo_stable_name = sumo_stable_name;
		}
		public Timestamp getCreated_at() {
			return created_at;
		}
		public void setCreated_at(Timestamp created_at) {
			this.created_at = created_at;
		}
		public Timestamp getUpdate_at() {
			return update_at;
		}
		public void setUpdate_at(Timestamp update_at) {
			this.update_at = update_at;
		}


		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getRikishi_info() {
			return rikishi_info;
		}

		public void setRikishi_info(String rikishi_info) {
			this.rikishi_info = rikishi_info;
		}






}


