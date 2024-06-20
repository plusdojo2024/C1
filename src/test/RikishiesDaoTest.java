package test;
import java.util.List;

import dao.RikishiesDao;
import model.Rikishies;

public class RikishiesDaoTest {
	public static void main(String[] args) {
		RikishiesDao dao = new RikishiesDao();


		// select()のテスト
		System.out.println("---------- 部屋初期表示のテスト ----------");
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
		System.out.println("---------- 待機部屋のテスト ----------");
		List<Rikishies> rikishiesList3 = dao.select_StandBy(new Rikishies("saku"));
		System.out.println("aiouo");
		for (Rikishies rikishies : rikishiesList3) {
			System.out.println("力士ID：" + rikishies.getId());
			System.out.println("画像：" + rikishies.getPic());
			System.out.println("力士名前：" + rikishies.getRikishi_name());
			System.out.println("ユーザーID：" + rikishies.getUser_id());


			System.out.println();
		}


		System.out.println("---------- 力士一覧初期表示のテスト ----------");
		List<Rikishies> rikishiesList4 = dao.select_rikishies(new Rikishies("awa"));
		System.out.println("aiouo");
		for (Rikishies rikishies : rikishiesList4) {
			System.out.println("力士ID：" + rikishies.getId());
			System.out.println("画像：" + rikishies.getPic());
			System.out.println("力士名前：" + rikishies.getRikishi_name());
			System.out.println("ユーザーID：" + rikishies.getUser_id());
			System.out.println("相撲協会URL：" + rikishies.getSumo_association_link());

			System.out.println();
		}


		System.out.println("---------- 力士検索のテスト ----------");
		List<Rikishies> rikishiesList5 = dao.select_rikishiesSearch(new Rikishies("saku", "伊勢"));
		System.out.println("aiouo");
		for (Rikishies rikishies : rikishiesList5) {
			System.out.println("力士ID：" + rikishies.getId());
			System.out.println("画像：" + rikishies.getPic());
			System.out.println("力士名前：" + rikishies.getRikishi_name());
			System.out.println("ユーザーID：" + rikishies.getUser_id());
			System.out.println("相撲協会URL：" + rikishies.getSumo_association_link());

			System.out.println();
		}

	}
}
