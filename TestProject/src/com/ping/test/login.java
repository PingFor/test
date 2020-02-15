package com.ping.test;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * Servlet implementation class hello
 */
@WebServlet(
		urlPatterns = { "/login" }, 
		initParams = { 
				@WebInitParam(name = "Site", value = "Ping Site"), 
				@WebInitParam(name = "password", value = "")
		})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		if(request.getSession() != null && request.getSession().getAttribute("user") != null && request.getSession().getAttribute("user").equals("ping")) {
			request.setAttribute("user", request.getSession().getAttribute("user"));
			request.getRequestDispatcher("welcome.jsp").forward(request, response);	
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isSave = request.getParameter("isSave")==null?"False":request.getParameter("isSave");
		boolean isSaveSession = Boolean.parseBoolean(isSave);
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		if(user != null && password != null && user.equals("ping") && password.equals("1234")) {
			if(isSaveSession) {
				request.getSession().setAttribute("user", "ping");
			}	
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);	
		}else {
			request.setAttribute("Msg", "Account Or Password Error!!!");
			doGet(request, response);
		}		
	}

}
