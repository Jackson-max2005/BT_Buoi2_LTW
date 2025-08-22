package vn.iotstart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/HelloSession" })
public class HelloSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");
			out.print("Chào bạn, " + name + " đến với trang đăng nhập session");
		} 
		else {
			out.print("Xin vui lòng đăng nhập");
			resp.sendRedirect("/HelloWorld/Login.html");
		}
	}
}
