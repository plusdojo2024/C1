package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stores implements Serializable{
	private int id;					//ID
	private String shop_name;	 //店名
	private String shop_pic;	//店の写真
	private String food_pic;	 //料理の写真
	private String shop_link;	 //店のリンク
	private String venue_name;	 //会場名
	private Timestamp created_at;	// 投稿日時
	private Timestamp updated_at;	// 更新日時
    //全て込みのコンストラクタ
	public Stores(int id, String shop_name, String shop_pic, String food_pic, String shop_link, String venue_name,
			Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.shop_name = shop_name;
		this.shop_pic = shop_pic;
		this.food_pic = food_pic;
		this.shop_link = shop_link;
		this.venue_name = venue_name;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	//Timestamp以外のコンストラクタ
		public Stores(int id, String shop_name, String shop_pic, String food_pic, String shop_link, String venue_name
				) {
			this.id = id;
			this.shop_name = shop_name;
			this.shop_pic = shop_pic;
			this.food_pic = food_pic;
			this.shop_link = shop_link;
			this.venue_name = venue_name;
		}
	//デフォルトコンストラクタ
	public Stores() {
	}
    //ゲッターセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_pic() {
		return shop_pic;
	}
	public void setShop_pic(String shop_pic) {
		this.shop_pic = shop_pic;
	}
	public String getFood_pic() {
		return food_pic;
	}
	public void setFood_pic(String food_pic) {
		this.food_pic = food_pic;
	}
	public String getShop_link() {
		return shop_link;
	}
	public void setShop_link(String shop_link) {
		this.shop_link = shop_link;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
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