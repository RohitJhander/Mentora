package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Index extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to Mentora </h1>");
		out.println("<h2>e-Counsellor is built by a team of young passionate engineers and is head-quartered at Phagwara. e-Counsellor is an online convenient way to contact students from prestigious colleges of India. You can schedule a call using mobile app.</h2>");
	}
}
