package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stars implements Serializable{
	//フィールド
	private int id;					//ID
	private int contribution_id;	 //投稿ID
	private String user_id;			// ユーザーID
	private Timestamp created_at;	// 投稿日時
	private Timestamp updated_at;	// 更新日時


	//全て込みのコンストラクタ
	public Stars(int id, int contribution_id, String user_id, Timestamp created_at, Timestamp updated_at)
	{
		this.id = id;
		this.contribution_id = contribution_id;
		this.user_id = user_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	//timestamo以外のコンストラクタ
	public Stars(int id, int contribution_id, String user_id)
	{
		this.id = id;
		this.contribution_id = contribution_id;
		this.user_id = user_id;
	}
	//デフォルトコンストラクタ
	public Stars() {
	}

	//ゲッターセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
