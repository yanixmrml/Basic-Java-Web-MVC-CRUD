package org.yanixmrml.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/listData")   
	private DataSource dataSource;
    private String urlPath = "/site";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getServletContext().getRequestDispatcher(getServletInfo()).forward(request, response);
		String selPage = request.getParameter("page");
		request.setAttribute("urlPath", urlPath);
		switch(selPage) {
			case "home":
				request.setAttribute("pageTitle", "Home");
				request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			default:
				request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		
		}
	}
	
}
