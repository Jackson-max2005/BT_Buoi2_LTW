package vn.iotstart.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns={"/HelloCookie"})
public class HelloCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name="";
		
		Cookie[] cookie = req.getCookies();
		for (Cookie c: cookie) {
		if(c.getName().equals("username")) {
		name = c.getValue();}}
		if(name.equals("")){
		
		resp.sendRedirect("/HelloServlet/LoginCookie.html");
		}
		
		printWriter.println("Xin chao " + name);
		
	}
}
