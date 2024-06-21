package test;
import java.util.List;

import dao.FavoritesDao;
import model.Favorites;

public class FavoritesDaoTest {
	public static void main(String[] args) {
		FavoritesDao dao = new FavoritesDao();
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Favorites> favoritesList2 = dao.select(new Favorites("saku",5));
		System.out.println("aiouo");
		for (Favorites favorites : favoritesList2) {
			System.out.println("ID：" + favorites.getId());
			System.out.println("ユーザーID：" + favorites.getUser_id());
			System.out.println("力士ID：" + favorites.getRikishi_id());
			System.out.println();
		}
		// insertStar()のテスト
				int starUpDelNumber = 0;
				Favorites insert = new Favorites("tana",3);
				System.out.println("---------- insertStar()のテスト ----------");
				if (dao.insert(insert)) {
					System.out.println("aiouo");
					List<Favorites> favoritesList5 = dao.select(insert);
					for (Favorites favorites : favoritesList5) {
						System.out.println("ID：" + favorites.getId());
						System.out.println("ユーザーID：" + favorites.getUser_id());
						System.out.println("力士ID：" + favorites.getRikishi_id());
						System.out.println("登録日時：" + favorites.getCreated_at());
						System.out.println("更新日時：" + favorites.getUpdated_at());
						System.out.println();
						starUpDelNumber = favorites.getId();	// 最後のレコードを後で更新および削除する
					}
				}
				else {
					System.out.println("登録失敗！");
				}
				// delete()のテスト
				System.out.println("---------- delete()のテスト ----------");
				if (dao.delete(insert)) {
					System.out.println("削除成功！");
				}
				else {
					System.out.println("削除失敗！");
				}

			}
	}
