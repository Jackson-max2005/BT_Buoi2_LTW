package vn.iotstart.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstart.model.UserModel;
import vn.iotstart.services.IUserService;
import vn.iotstart.services.impl.UserServiceImpl;
import vn.iotstart.untils.Constant;

@WebServlet(urlPatterns={"/LoginController"})
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/LoginCookie.html").forward(req, resp);
			return;
		}
		//Xử lí bài toán 
		
		UserModel user = service.login(username, password);
		
		if(user!=null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if(isRememberMe) {
				saveRememberMe(resp,username);
				
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		}else {
			alertMsg = "Tai khoan mat khau k dung";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
			
			
			
		}
		
	}
	
	private void saveRememberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,username);
				 cookie.setMaxAge(30*60);
				 resp.addCookie(cookie);
		
	}
	

}
