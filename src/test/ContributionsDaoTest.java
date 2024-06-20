package test;
import java.util.List;

import dao.ContributionsDao;
import model.Contributions;

public class ContributionsDaoTest {
	public static void main(String[] args) {
		ContributionsDao dao = new ContributionsDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Contributions> contributionsList2 = dao.select(new Contributions(5));
		System.out.println("aiouo");
		for (Contributions contributions : contributionsList2) {
			System.out.println("投稿ID：" + contributions.getId());
			System.out.println("ユーザーID：" + contributions.getUser_id());
			System.out.println("写真・動画：" + contributions.getPic_movie());
			System.out.println();
		}
	}
}
