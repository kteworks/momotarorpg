package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BattleLogic;
import model.Quest;
import model.QuestLogic;



@WebServlet("/BattleServlet")
public class BattleServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String act = request.getParameter("action");
		HttpSession session = request.getSession();
		Quest quest = (Quest)session.getAttribute("quest");
		QuestLogic qbo = new QuestLogic();
		BattleLogic bbo = new BattleLogic();
		bbo.action(quest, act);
		Integer lv = null;
		session.setAttribute("lv", lv);	
		
		if(act.equals("逃げる"))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("MainServlet");
			dispatcher.forward(request, response);
		}
		
		if(quest.getpRemainHP() <= 0)
		{
			qbo.lose(quest);
		}
		else if(quest.geteRemainHP() <= 0)
		{
			lv = qbo.victory(quest);
			if(!(lv.equals(0)))
			{
				session.setAttribute("lv", lv);	
			}
		}
		session.setAttribute("quest", quest);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/battle.jsp");
		dispatcher.forward(request, response);
	}
}	

