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

import dao.ContributionsDao;
import model.Contributions;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションを取得している
		HttpSession session = request.getSession();

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		//Users User = (Users)session.getAttribute("user_id");
		//String User_id = User.getUser_id();
		String User_id = "saku";

		// 初期表示の処理
		ContributionsDao contributions = new ContributionsDao();
		List<Contributions> contributionsList = contributions.selectReplyContribution(new Contributions(6,User_id));

		request.setAttribute("contributionsList", contributionsList);




		// 返信ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reply.jsp");
		dispatcher.forward(request, response);
	}
}
