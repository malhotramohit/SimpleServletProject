package com.gs.ilp.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DeleteProfileController
 */
@WebServlet("/deleteProfileController")
public class DeleteProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProfileService profileService = new ProfileService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		System.out.println("Seq is " + seq);
		try {
			profileService.deleteProfile(Long.valueOf(seq));
			List<ProfileModel> profileModels = profileService.getAllProfiles();
			request.setAttribute("listOfProfileModels", profileModels);
			request.setAttribute("deleteSuccessMsg", "Profile with id "+seq+" is deleted." );
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllProfile.jsp");
			dispatcher.forward(request, response);
		} catch (NumberFormatException | CustomException e) {
			e.printStackTrace();
			request.setAttribute("errorString", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
