package com.gs.ilp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.ilp.framework.CustomException;
import com.gs.ilp.model.ProfileModel;
import com.gs.ilp.service.ProfileService;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	static int seq=  new Random().nextInt();
	private ProfileService profileService = new ProfileService();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pswd = request.getParameter("pswd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		ProfileModel profileModel = new ProfileModel(++seq, email, pswd, fname, lname);

		try {
			profileService.saveProfile(profileModel);
			request.setAttribute("SuccessMsg", "Profile Created Successfully");
			List<ProfileModel> profileModels = profileService.getAllProfiles();
			request.setAttribute("listOfProfileModels", profileModels);

			//

			RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllProfile.jsp");
			dispatcher.forward(request, response);
		} catch (CustomException e) {
			e.printStackTrace();
			request.setAttribute("errorString", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
