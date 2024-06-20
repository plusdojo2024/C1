package test;

import java.util.List;

import dao.FollowsDao;
import model.Follows;

public class FollowsDaoTest {
	public static void main(String[] args) {
		FollowsDao dao = new FollowsDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Follows> followsList2 = dao.select(new Follows("saku"));
		System.out.println("aiouo");
		for (Follows follows : followsList2) {
			System.out.println("ユーザーID：" + follows.getFollow_user_id());
			System.out.println("ユーザ名：" + follows.getUser_name());
			System.out.println("アイコン：" + follows.getIcon());
			System.out.println("フォロー中：" + follows.getUser_id());
		}
	}
}
