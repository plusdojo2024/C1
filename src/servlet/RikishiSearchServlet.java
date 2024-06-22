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

import dao.RikishiesDao;
import model.Rikishies;
import model.Users;


/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/RikishiSearchServlet")
public class RikishiSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();

		// 検索処理を行う
		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select_rikishies(new Rikishies(User_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("rikishiesList", rikishiesList);


		// 力士検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rikishi.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//ゲットパラメータを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();
		String rikishi_info = request.getParameter("rikishi_info");


		// 検索処理を行う
		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select_rikishiesSearch(new Rikishies(User_id, rikishi_info));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("rikishiesList", rikishiesList);

		//力士検索・一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/rikishi.jsp");
		dispatcher.forward(request, response);

	}

}
