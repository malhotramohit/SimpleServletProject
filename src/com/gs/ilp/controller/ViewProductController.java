package com.gs.ilp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.ilp.dao.ProductModel;

/**
 * Servlet implementation class ViewProductController
 */
@WebServlet("/viewProductController")
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductModel> productModels= new ArrayList<>();
		ProductModel model= new  ProductModel("code1", "prod1", 445646.675f);
		ProductModel model1= new  ProductModel("code2", "prod2", 445646.675f);
		ProductModel model2= new  ProductModel("code3", "prod2", 445646.675f);
		ProductModel model3= new  ProductModel("code4", "prod2", 445646.675f);

		productModels.add(model);
		productModels.add(model1);
		productModels.add(model2);
		productModels.add(model3);
		
		request.setAttribute("productList", productModels);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
