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
import model.Users;

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
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/C1/LoginServlet");
			return;
		}

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();

		//クエリパラメータを取得
		String judge = request.getParameter("judge");
		int id = Integer.parseInt(request.getParameter("id"));

		//処理
		ContributionsDao contributions = new ContributionsDao();
		if (judge==null) {
	        String star = request.getParameter("star");
			if (star.equals("0")) {
				//starsテーブルにレコードを追加する処理
				contributions.insertStar(new Contributions(id, User_id));

			} else if (star.equals("1")) {
				//starsテーブルからレコードを削除する処理
				contributions.delete(new Contributions(id, User_id));

			}
		}

		// 初期表示の処理
		List<Contributions> contributionsList = contributions.selectReplyContribution(new Contributions(id, User_id));

		//返信の表示
		Contributions reply = new Contributions();
		reply.Reply(id);
		List<Contributions> replyList = contributions.selectReply(reply);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("contributionsList", contributionsList);
		request.setAttribute("replyList", replyList);




		// 返信ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reply.jsp");
		dispatcher.forward(request, response);
	}
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
		String text = request.getParameter("text");
		int id = Integer.parseInt(request.getParameter("id"));
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();


			// 返信の登録処理を行う
			ContributionsDao contributions = new ContributionsDao();
			Contributions insReply = new Contributions();
			insReply.InsReply(id, User_id,text);
			contributions.insertReply(insReply);

			// 初期表示の処理
			List<Contributions> contributionsList = contributions.selectReplyContribution(new Contributions(id, User_id));

			//返信の表示
			Contributions reply = new Contributions();
			reply.Reply(id);
			List<Contributions> replyList = contributions.selectReply(reply);

			// 検索結果をリクエストスコープに格納する
			request.setAttribute("contributionsList", contributionsList);
			request.setAttribute("replyList", replyList);

			// 返信ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reply.jsp");
			dispatcher.forward(request, response);
	}
}
