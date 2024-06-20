package test;
import java.util.List;

import dao.StoresDao;
import model.Stores;

public class StoresDaoTest {
	public static void main(String[] args) {
		StoresDao dao = new StoresDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Stores> storesList2 = dao.select(new Stores("東京"));
		System.out.println("aiouo");
		for (Stores stores : storesList2) {
			System.out.println("店名：" + stores.getShop_name());
			System.out.println("店の写真：" + stores.getShop_pic());
			System.out.println("料理の写真：" + stores.getFood_pic());
			System.out.println("店のリンク：" + stores.getShop_link());
			System.out.println("会場名：" + stores.getVenue_name());
			System.out.println();
		}
	}
}