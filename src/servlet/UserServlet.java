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
import dao.UsersDao;
import model.Follows;
import model.Users;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String follow = "";
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

				//ゲットパラメータを取得
				request.setCharacterEncoding("UTF-8");
				Users User = (Users)session.getAttribute("user_id");
				String User_id = User.getUser_id();

				//クエリパラメータを取得
		        String follow = request.getParameter("follow");
		        String follow_user_id = User.getFollow_user_id();


				//処理
				FollowsDao follows = new FollowsDao();
				if (follow.equals("0")) {
					//usersテーブルにレコードを追加する処理
					follows.insert(new Follows(User_id, follow_user_id));

				} else if (follow.equals("1")) {
					//userテーブルからレコードを削除する処理
					follows.delete(new Follows(User_id, follow_user_id));

				}


				// 初期表示のための全件検索を行う
				UsersDao users = new UsersDao();
				List<Users> usersList = users.select_usersearch(new Users(User_id));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("usersList", usersList);


				// 力士検索・一覧ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
				dispatcher.forward(request, response);
			}

		}
