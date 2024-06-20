package test;

import java.util.List;

import dao.UsersDao;
import model.Users;

public class UsersDaoTest {
	public static void main(String[] args) {
		testIsLoginOK1(); // ユーザーが見つかる場合のテスト
		testIsLoginOK2(); // ユーザーが見つからない場合のテスト

		UsersDao dao = new UsersDao();
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Users> usersList2 = dao.select(new Users("saku"));
		System.out.println("aiouo");
		for (Users users : usersList2) {
			System.out.println("ユーザーID：" + users.getUser_id());
			System.out.println("ユーザーネーム：" + users.getUser_name());
			System.out.println("アイコン：" + users.getIcon());
			System.out.println("メッセージ：" + users.getMessage());
			System.out.println("力士ID：" + users.getRikishi_id());
			System.out.println("力士写真：" + users.getPic());
			System.out.println("力士名前：" + users.getRikishi_name());
			System.out.println();
		}
		// select_other()のテスト
		System.out.println("---------- select_other()のテスト ----------");
		Users U = new Users();
		U.users("ogu", "saku");
		List<Users> usersList3 = dao.select_other(U);
		System.out.println("aiouo");

		for (Users users : usersList3) {
			System.out.println("ユーザーID：" + users.getUser_id());
			System.out.println("ユーザーネーム：" + users.getUser_name());
			System.out.println("アイコン：" + users.getIcon());
			System.out.println("メッセージ：" + users.getMessage());
			System.out.println("力士ID：" + users.getRikishi_id());
			System.out.println("力士写真：" + users.getPic());
			System.out.println("力士名前：" + users.getRikishi_name());
			System.out.println("フォローしているユーザーネーム：" + users.getFollow_user_id());
			System.out.println();
		}






		//select_mypagecontributions()のテスト
		System.out.println("---------- select_mypagecontributions()のテスト ----------");
		List<Users> usersList4 = dao.select_mypagecontributions(new Users("saku"));
		System.out.println("aiouo");
		for (Users users : usersList4) {
			System.out.println("ユーザーネーム：" + users.getUser_name());
			System.out.println("アイコン：" + users.getIcon());
			System.out.println("投稿の画像：" + users.getPic_movie());
			System.out.println();
		}




//		rs.getString("user_id"),
//		rs.getString("user_name"),
//		rs.getString("icon"),
//		rs.getString("follow_user_id"));
		//select_usersearch()のテスト
		System.out.println("---------- select_usersearch()のテスト ----------");
		List<Users> usersList5 = dao.select_usersearch(new Users("saku"));
		System.out.println("aiouo");
		for (Users users : usersList5) {
			System.out.println("ユーザーID：" + users.getUser_id());
			System.out.println("ユーザーネーム：" + users.getUser_name());
			System.out.println("アイコン：" + users.getIcon());
			System.out.println("フォローしているユーザーネーム：" + users.getFollow_user_id());
			System.out.println();
		}

	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		UsersDao dao = new UsersDao();
		if (dao.isLoginOK(new Users("saku", "s"))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		UsersDao dao = new UsersDao();
		if (!dao.isLoginOK(new Users("saku", "s"))) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}

}
