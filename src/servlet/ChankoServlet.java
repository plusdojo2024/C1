package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/c1/LoginServlet");
			return;
		}*/

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
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}*/
		request.setCharacterEncoding("UTF-8");
		/*	// リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String company = request.getParameter("company");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String hiraname = request.getParameter("hiraname");

			// 検索処理を行う
			BcDAO bDao = new BcDAO();
			List<Bc> cardList = bDao.select(new Bc(0,company,"","",name,"",address,"","",hiraname,""));

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);*/

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
