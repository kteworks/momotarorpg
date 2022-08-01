package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Player;
import model.Quest;
import model.QuestLogic;

/**
 * Servlet implementation class QuestServlet
 */
@WebServlet("/QuestServlet")
public class QuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Player player = (Player) session.getAttribute("player");
		String difficulty = request.getParameter("difficulty");
		QuestLogic bo = new QuestLogic();
		Quest quest = (Quest)session.getAttribute("quest");
		
		if (difficulty != null) {
			quest = bo.initializeQuest(account, player, difficulty);
			session.setAttribute("quest", quest);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/move.jsp");
			dispatcher.forward(request, response);
		}

		if (quest.getpRemainHP() <= 0) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
			dispatcher.forward(request, response);
		}
		else if(quest.geteRemainHP() <= 0 && quest.getStage() == 3)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
			dispatcher.forward(request, response);
		}
		else if(quest.geteRemainHP() <= 0)
		{
			bo = new QuestLogic();
			quest = bo.nextStage(quest);
			session.setAttribute("quest",quest);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/move.jsp");
			dispatcher.forward(request, response);
		}
		
		session.removeAttribute("lv");
		response.sendRedirect("jsp/battle.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Player player = (Player) session.getAttribute("player");
		String difficulty = request.getParameter("difficulty");
		QuestLogic bo = new QuestLogic();
		Quest quest = (Quest)session.getAttribute("quest");
		session.removeAttribute("lv");
		
		
		if (difficulty != null) {
			quest = bo.initializeQuest(account, player, difficulty);
			session.setAttribute("quest", quest);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/move.jsp");
			dispatcher.forward(request, response);
		}
		
		if (quest.getpRemainHP() <= 0) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
			dispatcher.forward(request, response);
		}
		else if(quest.geteRemainHP() <= 0 && quest.getStage() == 3)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
			dispatcher.forward(request, response);
		}
		else if(quest.geteRemainHP() <= 0)
		{
			bo = new QuestLogic();
			quest = bo.nextStage(quest);
			session.setAttribute("quest",quest);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/move.jsp");
			dispatcher.forward(request, response);
		}

	}

}
