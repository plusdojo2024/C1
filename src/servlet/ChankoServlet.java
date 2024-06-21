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

import dao.StoresDao;
import model.Stores;
import model.Users;

/**
 * Servlet implementation class ChankoServlet
 */
@WebServlet("/ChankoServlet")
public class ChankoServlet extends HttpServlet {
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
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();



		// ちゃんこページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chanko.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String Store_venue_name = request.getParameter("venue");



			// 検索処理を行う
			StoresDao stores = new StoresDao();
			List<Stores> storesList = stores.select(new Stores(Store_venue_name));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("storesList", storesList);

		// レシピ検索結果、お店検索結果へ遷移
		System.out.println("submit:" + request.getParameter("submit"));
		if (request.getParameter("submit").equals("レシピ検索")) {
			// レシピ検索結果にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipe.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("submit").equals("お店検索")) {
			// レシピ検索結果にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/store.jsp");
			dispatcher.forward(request, response);
		}
	}
}
