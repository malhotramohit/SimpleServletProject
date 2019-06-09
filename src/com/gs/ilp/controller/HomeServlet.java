package com.gs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.ilp.framework.CustomException;
import com.gs.ilp.service.ProfileService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HomeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("pswd");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Hello from Get</h1>");
		ProfileService profileService = new ProfileService();
		// boolean isLoginAllowed = profileService.doAuthentication(username, password);
		printWriter.println("Username from request is " + username + " password is " + password);
		HttpSession httpSession = request.getSession();
		if (username != null && password != null) {

			httpSession.setAttribute("username", username);
			httpSession.setAttribute("password", password);
		}

		printWriter.println("<br>Username from session is " + httpSession.getAttribute("username") + " password is "
				+ httpSession.getAttribute("password"));

		ServletContext servletContext = request.getServletContext();

		if (username != null && password != null) {

			servletContext.setAttribute("username", username);
			servletContext.setAttribute("password", password);
		}

		printWriter.println("<br>Username from contex is " + servletContext.getAttribute("username") + " password is "
				+ servletContext.getAttribute("password"));

		// if (isLoginAllowed) {
		// printWriter.println("Username from request is " + username + " password is "
		// + password);
		// } else {
		// printWriter.println("Either username or password is invalid");
		//
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pswd = request.getParameter("pswd");
		ProfileService profileService = new ProfileService();
//		try {
//			profileService.saveProfile();
//		} catch (CustomException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			request.setAttribute("errormsg", e.getMessage());
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
//			requestDispatcher.forward(request, response);
//		}

	}

}
