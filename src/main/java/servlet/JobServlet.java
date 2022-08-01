package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.Account;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String cName = request.getParameter("cName");
		HttpSession session = request.getSession();
				
		Account account = (Account)session.getAttribute("account");
		RegisterDAO dao = new RegisterDAO();
		dao.characterMake(account, cName);
		
		if(account.getJob_id() == -1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/select.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("MainServlet");
		}
	}
}
