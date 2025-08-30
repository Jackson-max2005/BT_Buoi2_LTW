package vn.iotstart.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.model.UserModel;
import vn.iotstart.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		 req.setCharacterEncoding("UTF-8");
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 boolean isRememberMe = false;
		 String remember = req.getParameter("rememb");
		 if("on".equals(remember)){
			 isRememberMe = true;
			 }
	     String alertMsg="";
		 if(username.isEmpty() || password.isEmpty()) {
			 alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			 return;
		 }
		 UserServiceImpl service = new UserServiceImpl();
		 UserModel user = service.login(username, password);
		 if(user!=null) {
			 HttpSession session = req.getSession(true);
			 session.setAttribute("account", user);
			 if(isRememberMe){
			 saveRemeberMe(resp, username);
			 }
			 resp.sendRedirect(req.getContextPath()+"/waiting");
			 }else{
			 alertMsg =
			"Tài khoản hoặc mật khẩu không đúng";
			 req.setAttribute("alert", alertMsg);
			 req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			 }

		 }
		 
		 		
	
			  
			  
		
	}

}
