package com.gs.ilp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gs.ilp.framework.ServiceFactory;
import com.gs.ilp.service.ProfileService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("uname");
		String password = request.getParameter("pswd");

		ProfileService profileService = (ProfileService) ServiceFactory.getInstance(ProfileService.class);
		boolean isLoginAllowed = profileService.doAuthentication(username, password);

		if (isLoginAllowed) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("username", username);
			request.setAttribute("password", password);
			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("errorString", "Password for " + username + " is not correct");

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}

		/*
		 * 
		 * String[] cities = request.getParameterValues("cities");
		 * 
		 * if (username.equals("admin") && password.equals("admin")) {
		 * response.getWriter().append("Login Success"); for (String str : cities) {
		 * response.getWriter().append("cities selected are " + str); } } else {
		 * response.getWriter().append("retry"); }
		 * 
		 */

	}

}
