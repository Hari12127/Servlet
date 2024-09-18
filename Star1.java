package mahi;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/lomo1")
public class Star1 extends HttpServlet{
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
	    RequestDispatcher rd=req.getRequestDispatcher("/reg.jsp");
			rd.forward(req, res);
}
}