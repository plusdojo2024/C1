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
 * Servlet implementation class StandByServlet
 */
@WebServlet("/StandByServlet")
public class StandByServlet extends HttpServlet {
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

		// 初期表示のための全件検索を行う
		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select_StandBy(new Rikishies(User_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("rikishiesList", rikishiesList);

		// 待機部屋にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/standBy.jsp");
		dispatcher.forward(request, response);
	}

}
