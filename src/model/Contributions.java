package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Contributions implements Serializable {
	//フィールド
	private int id;					// 投稿ID
	private String user_id;			// ユーザーID
	private int rikishi_id;			// 力士ID
	private String pic_movie;		/* 写真・動画 */
	private String text;			// 投稿テキスト
	private Timestamp created_at;	// 投稿日時
	private Timestamp updated_at;	// 更新日時
	private String stars_user_id;	// 白星をつけたユーザーのuser_id
	private String icon;			// 白星をつけたユーザーのicon
	private String user_name;	// 白星をつけたユーザーのuser_name


	//全部入りのコンストラクタ
	public Contributions(int id, String user_id, int rikishi_id, String pic_movie, String text, Timestamp created_at,
			Timestamp updated_at, String stars_user_id, String icon, String user_name) {
		this.id = id;
		this.user_id = user_id;
		this.rikishi_id = rikishi_id;
		this.pic_movie = pic_movie;
		this.text = text;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.stars_user_id = stars_user_id;
		this.icon = icon;
		this.user_name = user_name;
	}


	//力士IDでSELECTする用のコンストラクタ(検索に入るとき)
	public Contributions(int rikishi_id) {
		this.rikishi_id = rikishi_id;

	}
	//力士の各部屋に表示する投稿のコンストラクタ(検索に入るとき)
	public Contributions(int id, String user_id,String pic_movie) {
			this.id = id;
			this.user_id = user_id;
			this.pic_movie = pic_movie;
	}
	// 返信ページで、１つの投稿を白星込みで表示するための表示用コンストラクタ
	public Contributions(String user_id, int rikishi_id, int id, String icon, String user_name, String pic_movie,
			String text, String stars_user_id) {
		this.user_id = user_id;
		this.rikishi_id = rikishi_id;
		this.id = id;
		this.icon = icon;
		this.user_name = user_name;
		this.pic_movie = pic_movie;
		this.text = text;
		this.stars_user_id = stars_user_id;
	}
	// 返信ページで、１つの投稿を白星込みで表示するための検索用コンストラクタ
	public Contributions(int id, String stars_user_id) {
			this.id = id;
			this.stars_user_id = stars_user_id;
	}
	// 投稿IDで返信をSELECTした結果を送るためのコンストラクタ
	public Contributions(String user_id, String user_name, String text) {
			this.user_id = user_id;
			this.user_name = user_name;
			this.text = text;
	}

	//デフォルトコンストラクタ
	public Contributions() {

	}

	//投稿IDで返信をSELECTする用のメソッド
	public void Reply(int id) {
		this.id = id;
	}


	//getter,setter
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

	public String getPic_movie() {
		return pic_movie;
	}

	public void setPic_movie(String pic_movie) {
		this.pic_movie = pic_movie;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getStars_user_id() {
		return stars_user_id;
	}

	public void setStars_user_id(String stars_user_id) {
		this.stars_user_id = stars_user_id;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
