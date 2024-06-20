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


	//全部入りのコンストラクタ(検索に入るとき)
	public Contributions(int id, String user_id, int rikishi_id, String pic_movie, String text, Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.rikishi_id = rikishi_id;
		this.pic_movie = pic_movie;
		this.text = text;
		this.created_at = created_at;
		this.updated_at = updated_at;

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

	//デフォルトコンストラクタ
	public Contributions() {

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

}
