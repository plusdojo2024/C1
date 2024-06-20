package test;
import java.util.List;

import dao.StarsDao;
import model.Stars;

public class StarsDaoTest {
	public static void main(String[] args) {
		StarsDao dao = new StarsDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Stars> starsList2 = dao.select(new Stars("saku"));
		System.out.println("aiouo");
		for (Stars stars : starsList2) {
		    System.out.println("白星をつけたユーザーID：" + stars.getStar());
			System.out.println("投稿ID：" + stars.getContribution_id());
			System.out.println("投稿したユーザー：" + stars.getUser_id());
			System.out.println("ユーザーアイコン：" + stars.getIcon());
			System.out.println("ユーザーネーム：" + stars.getUser_name());
			System.out.println("投稿動画、画像：" + stars.getPic_movie());
			System.out.println();
		}
	}
}
