package test;
import java.util.List;

import dao.BcDAO;
import model.Bc;

public class BcDAOTest {
	public static void main(String[] args) {
		BcDAO dao = new BcDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Bc> cardList2 = dao.select(new Bc());
		for (Bc card : cardList2) {
			System.out.println("番号：" + card.getNumber());
			System.out.println("会社名：" + card.getCompany());
			System.out.println("会社名(ふりがな)：" + card.getC_furigana());
			System.out.println("部署名：" + card.getDepartment());
			System.out.println("役職名：" + card.getPosition());
			System.out.println("苗字(漢字)：" + card.getLast_name());
			System.out.println("名前(漢字)：" + card.getFirst_name());
			System.out.println("苗字(ふりがな)：" + card.getLn_furigana());
			System.out.println("名前(ふりがな)：" + card.getFn_furigana());
			System.out.println("郵便番号：" + card.getZipcode());
			System.out.println("住所：" + card.getAddress());
			System.out.println("電話番号：" + card.getPhone());
			System.out.println("FAX番号：" + card.getFax());
			System.out.println("メールアドレス：" + card.getEmail());
			System.out.println("備考：" + card.getRemarks());
			System.out.println("登録日：" + card.getDate());
			System.out.println();
		}

		// insert()のテスト
		int upDelNumber = 0;		// 後で更新および削除する番号
		System.out.println("---------- insert()のテスト ----------");
		Bc insRec = new Bc(0, "テスト会社", "てすとかいしゃ", "テスト部",
				"部長", "テスト", "太郎", "てすと", "たろう", "107-6010",
				"東京都港区赤坂", "047-106-1060", "047-106-1061",
				"test@domoco.ne.jp", "これはテストの情報です。", "2024/01/01 12:00:00");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Bc> cardList3 = dao.select(insRec);
			for (Bc card : cardList3) {
				System.out.println("番号：" + card.getNumber());
				System.out.println("会社名：" + card.getCompany());
				System.out.println("会社名(ふりがな)：" + card.getC_furigana());
				System.out.println("部署名：" + card.getDepartment());
				System.out.println("役職名：" + card.getPosition());
				System.out.println("苗字(漢字)：" + card.getLast_name());
				System.out.println("名前(漢字)：" + card.getFirst_name());
				System.out.println("苗字(ふりがな)：" + card.getLn_furigana());
				System.out.println("名前(ふりがな)：" + card.getFn_furigana());
				System.out.println("郵便番号：" + card.getZipcode());
				System.out.println("住所：" + card.getAddress());
				System.out.println("電話番号：" + card.getPhone());
				System.out.println("FAX番号：" + card.getFax());
				System.out.println("メールアドレス：" + card.getEmail());
				System.out.println("備考：" + card.getRemarks());
				System.out.println("登録日：" + card.getDate());
				System.out.println();
				upDelNumber = card.getNumber();	// 最後のレコードを後で更新および削除する
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Bc upRec = new Bc(upDelNumber, "株式会社更新", "かぶしきかいしゃこうしん",
				"更新部","社員", "更新", "次郎", "こうしん", "じろう", "117-6010",
				"東京都港区赤坂", "047-106-1160", "047-106-1161",
				"koshin@outlook.jp", "これは更新の情報です。", "2024/12/31 23:59:59");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Bc> cardList4 = dao.select(upRec);
			for (Bc card : cardList4) {
				System.out.println("番号：" + card.getNumber());
				System.out.println("会社名：" + card.getCompany());
				System.out.println("会社名(ふりがな)：" + card.getC_furigana());
				System.out.println("部署名：" + card.getDepartment());
				System.out.println("役職名：" + card.getPosition());
				System.out.println("苗字(漢字)：" + card.getLast_name());
				System.out.println("名前(漢字)：" + card.getFirst_name());
				System.out.println("苗字(ふりがな)：" + card.getLn_furigana());
				System.out.println("名前(ふりがな)：" + card.getFn_furigana());
				System.out.println("郵便番号：" + card.getZipcode());
				System.out.println("住所：" + card.getAddress());
				System.out.println("電話番号：" + card.getPhone());
				System.out.println("FAX番号：" + card.getFax());
				System.out.println("メールアドレス：" + card.getEmail());
				System.out.println("備考：" + card.getRemarks());
				System.out.println("登録日：" + card.getDate());
				System.out.println();
			}
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(upDelNumber)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}
