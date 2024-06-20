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

		// selectReplyContribution()のテスト
		System.out.println("---------- selectReplyContribution()のテスト ----------");
		List<Contributions> contributionsList3 = dao.selectReplyContribution(new Contributions(6, "saku"));
		System.out.println("aiouo");
		for (Contributions contributions : contributionsList3) {
			System.out.println("ユーザーID：" + contributions.getUser_id());
			System.out.println("力士ID：" + contributions.getRikishi_id());
			System.out.println("投稿ID：" + contributions.getId());
			System.out.println("ユーザーアイコン：" + contributions.getIcon());
			System.out.println("ユーザーネーム：" + contributions.getUser_name());
			System.out.println("写真・動画：" + contributions.getPic_movie());
			System.out.println("投稿テキスト：" + contributions.getText());
			System.out.println("Starの有無(自分のID)：" + contributions.getStars_user_id());
			System.out.println();
		}

		// selectReply()のテスト
		Contributions reply = new Contributions();
		reply.Reply(1);
		System.out.println("---------- selectReply()のテスト ----------");
		List<Contributions> contributionsList4 = dao.selectReply(reply);
		System.out.println("aiouo");
		for (Contributions contributions : contributionsList4) {
			System.out.println("ユーザーID：" + contributions.getUser_id());
			System.out.println("ユーザーネーム：" + contributions.getUser_name());
			System.out.println("投稿テキスト：" + contributions.getText());
			System.out.println();
		}
	}
}
