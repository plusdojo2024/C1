package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FollowsDao;
import model.Follows;
import model.Users;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/FollowServlet")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//ゲットパラメータを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users) session.getAttribute("user_id");
		String User_id = User.getUser_id();

		//クエリパラメータを取得
		String follow = request.getParameter("follow");
		String follow_user_id = request.getParameter("id");

		//Daoの呼び出し
		FollowsDao follows = new FollowsDao();

		//フォロー解除の処理
		if (follow != null) {
			follows.delete(new Follows(User_id, follow_user_id));
		}

		// 初期表示のための全件検索を行う
		List<Follows> followsList = follows.select(new Follows(User_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("followsList", followsList);


		// ユーザー検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/follow.jsp");
		dispatcher.forward(request, response);
	}

}

