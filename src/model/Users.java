package model;

import java.io.Serializable;
import java.sql.Timestamp;





public class Users implements Serializable {


	//フィールド
	private int id;					//ID
	private String user_id;				//ユーザーID
	private String password;			//パスワード
	private String user_name;			//ユーザーネーム
	private String icon;				//アイコン
	private String message;				//メッセージ
	private String ask;					//質問
	private String question;			//質問の答え
	private Timestamp created_at;		//追加時間
	private Timestamp updated_at;		//更新時間



	//引数がないコンストラクタ（javabeansの仕様上作らないといけない）
	public Users() {

	}



	//全部入りのコンストラクタ（検索に入るとき）
	public Users(int id, String user_id, String password, String user_name, String icon, String message, String ask,
			String question, Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.icon = icon;
		this.message = message;
		this.ask = ask;
		this.question = question;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getAsk() {
		return ask;
	}



	public void setAsk(String ask) {
		this.ask = ask;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
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
