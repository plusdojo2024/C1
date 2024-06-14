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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


}
