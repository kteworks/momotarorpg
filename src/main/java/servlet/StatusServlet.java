package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StatusDAO;
import model.Account;
import model.Player;

@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Player player = (Player) session.getAttribute("player");
		int status0 = Integer.parseInt(request.getParameter("atk"));
		int status1 = Integer.parseInt(request.getParameter("def"));
		int status2 = Integer.parseInt(request.getParameter("spd"));
		String jsp = request.getParameter("jsp");
		String Msg = "";

		if (account.getSkillPoint() < (status0 + status1 + status2)) {
			Msg = "そんなに上げられません";
			request.setAttribute("errorMsg", Msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		}

		else if (account.getSkillPoint() >= (status0 + status1 + status2) && 0 < (status0 + status1 + status2)) {
			StatusDAO dao = new StatusDAO();
			dao.statusAllocation(account, player, status0, status1, status2);
			session.setAttribute("account", account);
			session.setAttribute("player", player);
			Msg += "スキルポイントの割り振りが完了しました。";
			session.removeAttribute("lv");
			request.setAttribute("msg", Msg);
		}
		
		if (jsp.equals("jsp/battle.jsp")) {
			response.sendRedirect("QuestServlet");
		} else {
			response.sendRedirect(jsp);
		}
		
	}

}
