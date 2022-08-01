package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDAO;
import dao.ShopitemListDAO;
import model.Account;
import model.Player;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String iName = request.getParameter("iName");	
		Account account = (Account)session.getAttribute("account");
		ShopitemListDAO dao = new ShopitemListDAO();
		
		if(dao.OrderItem(account, iName))
		{
			session.setAttribute("account", account);
			PlayerDAO pdao = new PlayerDAO();
			Player player = pdao.initializePlayer(account);
			session.setAttribute("player", player);
			request.setAttribute("msg", "購入しました。");
		}
		else
		{
			request.setAttribute("errorMsg", "購入できませんでした。");
		}		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/shop.jsp");
		dispatcher.forward(request, response);
	}
}
