package test;
import java.util.List;

import dao.FavoritesDao;
import model.Favorites;

public class FavoritesDaoTest {
	public static void main(String[] args) {
		FavoritesDao dao = new FavoritesDao();

		 // selectメソッドのテスト
        System.out.println("---------- select()のテスト ----------");
        Favorites searchParam = new Favorites(0,"英語", "ここは英語を勉強したい人が集まるチャンネルです。", "2019-12-25 21:05:00");
        searchParam.setChName("");  // Modify as needed for specific search criteria

        List<Favorites> favoritesList2 = dao.select(favorites);
        for (Favorites favorites :favoritesList2 ) {
            System.out.println("チャンネルID ：" + channel.getChannelId());
            System.out.println("チャンネルネーム：" + channel.getChName());
            System.out.println("チャンネルコメント：" + channel.getChComment());
            System.out.println("チャンネル作成日付：" + channel.getCreatedAt());
            System.out.println();
        }
｝
｝