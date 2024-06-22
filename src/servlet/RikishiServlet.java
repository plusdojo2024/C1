package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoritesDao;
import dao.RikishiesDao;
import model.Favorites;
import model.Rikishies;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/RikishiServlet")
public class RikishiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}*/

		//ゲットパラメータを取得
		request.setCharacterEncoding("UTF-8");
		//Users User = (Users)session.getAttribute("user_id");
		//String User_id = User.getUser_id();
		String User_id = "saku";

		//クエリパラメータを取得
        String favorite = request.getParameter("favorite");
		int rikishi_id = Integer.parseInt(request.getParameter("rikishi_id"));


		//処理
		FavoritesDao favorites = new FavoritesDao();
		if (favorite.equals("0")) {
			//favoriteテーブルにレコードを追加する処理
			favorites.insert(new Favorites(User_id, rikishi_id));

		} else if (favorite.equals("1")) {
			//favoriteテーブルからレコードを削除する処理
			favorites.delete(new Favorites(User_id, rikishi_id));

		}


		// 初期表示のための全件検索を行う
		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select_rikishies(new Rikishies(User_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("rikishiesList", rikishiesList);


		// 力士検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rikishi.jsp");
		dispatcher.forward(request, response);
	}

}
