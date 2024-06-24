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
import dao.RikishiesDao;
import dao.UsersDao;
import model.Contributions;
import model.Rikishies;
import model.Users;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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

		//リクエストスコープを取得
		request.setCharacterEncoding("UTF-8");
		Users User = (Users)session.getAttribute("user_id");
		String User_id = User.getUser_id();

		//クエリパラメータを取得
		int Rikishi_id = Integer.parseInt(request.getParameter("rikishi_id"));

		//各種情報を取得する
		UsersDao users = new UsersDao();
		List<Users> usersList = users.select_other(new Users(User_id));
		request.setAttribute("usersList", usersList);

		RikishiesDao rikishies = new RikishiesDao();
		List<Rikishies> rikishiesList = rikishies.select(new Rikishies(Rikishi_id));
		request.setAttribute("rikishiesList", rikishiesList);

		ContributionsDao contributions = new ContributionsDao();
		List<Contributions> contributionsList = contributions.select(new Contributions(Rikishi_id));
		request.setAttribute("contributionsList", contributionsList);

		// 各部屋ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room.jsp");
		dispatcher.forward(request, response);
	}

}
