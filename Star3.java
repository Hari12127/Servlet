package mahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/lomo3")
public class Star3 extends HttpServlet{
@Override	
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException{
		String q=req.getParameter("n1");
		String q1=req.getParameter("e1");
	    String q2=req.getParameter("p1");
		String q3=req.getParameter("gen1");
		String q4=req.getParameter("c1");
		PrintWriter p=res.getWriter();
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String user="root";
	String pass="harish";
	String url="jdbc:mysql://localhost:3306/project1";
	Connection o=DriverManager.getConnection(url,user,pass);
	String w="insert into register(Name, Email, Pass, Gender,city)values(?,?,?,?,?);";
	PreparedStatement p1=o.prepareStatement(w);
	p1.setString(1, q);
	p1.setString(2, q1);
	p1.setString(3, q2);
	p1.setString(4, q3);
	p1.setString(5, q4);
	int a=p1.executeUpdate();
	if(a>0) {
		p.print("<h1>INSERTED SUCCESSFULLY</h1>");
		RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
		rd.include(req, res);
	}
	else {
		p.print("<h1>INSERTING FAILED</h1>");
		RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
		rd.include(req, res);
	}
}catch(Exception e) {
	System.out.println("ERROR");
}
		
}}
