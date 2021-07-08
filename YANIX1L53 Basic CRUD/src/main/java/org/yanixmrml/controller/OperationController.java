package org.yanixmrml.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.yanixmrml.entity.User;
import org.yanixmrml.model.UserModel;

/**
 * Servlet implementation class OperationController
 * @Author: Mark Ryan Longhas
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/listData")   
	private DataSource dataSource;
    private String operationPath = "/operation";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getServletContext().getRequestDispatcher(getServletInfo()).forward(request, response);
		String action = request.getParameter("page");
		request.setAttribute("operationPath", operationPath);
		switch(action==null?"":action.toLowerCase()) {
			case "listuser":
				this.listUser(request, response);	
				break;
			case "adduser":
				this.addUserFormLoader(request, response);
				break;
			case "updateuser":
				this.updateUserFormLoader(request, response);
				break;
			case "deleteuser":
				this.deleteUserOperation(request, response);
				break;
			default:
				request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("form");
		switch(operation==null?"":operation.toLowerCase()) {
			case "adduseroperation":
				addUserOperation(request,response);
				break;
			case "updateuseroperation":
				updateUserOperation(request,response);
				break;
			default:
				request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);	
		}

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageTitle", "List User");
		List<User> userList = null;
		try {
			userList = new UserModel().getUserList(dataSource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		}
		request.setAttribute("userList", userList);
		request.getServletContext().getRequestDispatcher("/listUser.jsp").forward(request, response);
	}
	
	private void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageTitle", "Add User");
		request.getServletContext().getRequestDispatcher("/addUser.jsp").forward(request, response);
	}
	
	private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageTitle", "Update User");
		User user = null;
		try {
			int userID = Integer.parseInt(request.getParameter("userID")); 
			user = new UserModel().getUser(dataSource, userID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null) {
			request.setAttribute("user", user);
			request.getServletContext().getRequestDispatcher("/updateUser.jsp").forward(request, response);
		}else {
			request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); 
		}
	}

	private void addUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("pageTitle", "Add User");
		User user = new User(request.getParameter("username"),request.getParameter("password"),request.getParameter("lastname"),
				request.getParameter("lastname"),request.getParameter("middlename"));
		try {
			new UserModel().addUser(dataSource,user);
			System.out.println("Adding is Success");
			//listUser(request,response);
			response.sendRedirect(request.getContextPath() + "/operation?page=listuser");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserID : " + request.getParameter("userID"));
		try {
			User user = new User(Integer.parseInt(request.getParameter("userID")),request.getParameter("username"),request.getParameter("password"),request.getParameter("lastname"),
					request.getParameter("lastname"),request.getParameter("middlename"));
			new UserModel().updateUser(dataSource,user);
			System.out.println("Updating is Success");
			//listUser(request,response);
			response.sendRedirect(request.getContextPath() + "/operation?page=listuser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserID : " + request.getParameter("userID"));
		try {
			new UserModel().deleteUser(dataSource,Integer.parseInt(request.getParameter("userID")));
			System.out.println("Deleting is Success");
			response.sendRedirect(request.getContextPath() + "/operation?page=listuser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}