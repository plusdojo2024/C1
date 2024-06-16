package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/RikishiServlet")
public class RikishiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String favorite = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (favorite.equals("0")) {
			//favoriteテーブルにレコードを追加する処理！

		} else if (favorite.equals("1")) {
			//favoriteテーブルからレコードを削除する処理！

		}
		if (false) {

		}




		// ユーザー検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rikishi.jsp");
		dispatcher.forward(request, response);
	}

}
