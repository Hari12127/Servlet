package mahi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/akku")
public class Star4 extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		
		String h=req.getParameter("n1");
		String h1=req.getParameter("pass1");
		PrintWriter i=res.getWriter();
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String user="root";
		String pass="harish";
		String url="jdbc:mysql://localhost:3306/project1";
		Connection o=DriverManager.getConnection(url,user,pass);
		String e="select * from register where Name=? and pass=?;";
		PreparedStatement p2=o.prepareStatement(e);
		p2.setString(1,h);
		p2.setString(2,h1);
		ResultSet r=p2.executeQuery();
		if(r.next()) {
			RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
			rd.include(req, res);
		}
		else {
			i.print("<h1 style='color:red'> failed</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/reg.jsp");
			rd.include(req, res);
		}
		
		}catch (Exception e){
			System.out.println(e);
		}
}

}



