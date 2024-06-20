package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stars implements Serializable{
	//フィールド
	private String star;	 //白星をつけたユーザーのID
	private int contribution_id;	 //投稿ID
	private String user_id;			// ユーザーID
	private String icon;            //ユーザーアイコン
	private String user_name;       //ユーザーネーム
	private String pic_movie;       //投稿画像、動画
	private Timestamp created_at;	// 投稿日時
	private Timestamp updated_at;	// 更新日時


  //全て込みのコンストラクタ
	public Stars(String star, int contribution_id, String user_id, String icon, String user_name, String pic_movie,
			Timestamp created_at, Timestamp updated_at) {
		this.star =star;
		this.contribution_id = contribution_id;
		this.user_id = user_id;
		this.icon = icon;
		this.user_name = user_name;
		this.pic_movie = pic_movie;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



	//timestamp以外のコンストラクタ
	public Stars(String star, int contribution_id, String user_id,String icon, String user_name, String pic_movie)
	{
		this.star = star;
		this.contribution_id = contribution_id;
		this.user_id = user_id;
		this.icon = icon;
		this.user_name = user_name;
		this.pic_movie = pic_movie;

	}

	//白星を付けたユーザーでSELECTする用のコンストラクタ(検索に入るとき)
			public Stars(String star) {
				this.star = star;

			}
	//デフォルトコンストラクタ
	public Stars() {
	}

	//ゲッターセッター




	public int getContribution_id() {
		return contribution_id;
	}



	public void setContribution_id(int contribution_id) {
		this.contribution_id = contribution_id;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
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



	public String getPic_movie() {
		return pic_movie;
	}



	public void setPic_movie(String pic_movie) {
		this.pic_movie = pic_movie;
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



	public String getStar() {
		return star;
	}



	public void setStar(String star) {
		this.star = star;
	}

}



