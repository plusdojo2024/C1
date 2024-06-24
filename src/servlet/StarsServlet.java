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

import dao.StarsDao;
import model.Stars;
import model.Users;

/**
 * Servlet implementation class StarsServlet
 */
@WebServlet("/StarsServlet")
public class StarsServlet extends HttpServlet {
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
		StarsDao stars = new StarsDao();
		List<Stars> starsList = stars.select(new Stars(User_id));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("starsList", starsList);


		// 白星一覧にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/stars.jsp");
		dispatcher.forward(request, response);

	}

}
