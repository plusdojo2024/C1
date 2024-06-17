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
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String follow = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (follow.equals("0")) {
			//followテーブルにレコードを追加する処理！

		} else if (follow.equals("1")) {
			//followテーブルからレコードを削除する処理！

		}
		if (false) {
			//()の中でfollowsテーブルのuser_idに自分のidの入ったレコードをDAOからもらう。
			//で、それをリクエストスコープでフォワード先に送る
		}

		//usersテーブルのidにfollowsテーブルのuser_idを外部結合して、
		//users.user_id,users.pic,follows.follow_user_idの項目で取り出し
		//それをリクエストスコープでフォワード先に送る


		// ユーザー検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);
	}

}
