package test;
import java.util.List;

import dao.RikishiesDao;
import model.Rikishies;

public class RikishiesDaoTest {
	public static void main(String[] args) {
		RikishiesDao dao = new RikishiesDao();


		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Rikishies> rikishiesList2 = dao.select(new Rikishies(1));
		System.out.println("aiouo");
		for (Rikishies rikishies : rikishiesList2) {
			System.out.println("力士ID：" + rikishies.getId());
			System.out.println("画像：" + rikishies.getPic());
			System.out.println("力士名前：" + rikishies.getRikishi_name());
			System.out.println("力士プロフィール：" + rikishies.getRikishi_profile());


			System.out.println();
		}

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Rikishies> rikishiesList3 = dao.select_StandBy(new Rikishies("saku"));
		System.out.println("aiouo");
		for (Rikishies rikishies : rikishiesList3) {
			System.out.println("力士ID：" + rikishies.getId());
			System.out.println("画像：" + rikishies.getPic());
			System.out.println("力士名前：" + rikishies.getRikishi_name());
			System.out.println("ユーザーID：" + rikishies.getUser_id());


			System.out.println();
		}


	}
}
