package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class CityServlet extends HttpServlet{
//房价查询
	private static final long serialVersionUID = 1L;


	public CityServlet() {
        super();
    }

	//public static String website;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String u_city = request.getParameter("u_city");

		out();
		System.out.println("hello");

		if("郑州".equals(u_city)) {
			response.sendRedirect("1.html");
		}else if("西安".equals(u_city)) {
			response.sendRedirect("2.html");
		}else if(u_city==null||u_city==""){
			response.sendRedirect("NotInput.html");
		}else{
			response.sendRedirect("NotFound.html");
		}

		
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	public void out(){
		System.out.println("hhhhhh");
	}

}
