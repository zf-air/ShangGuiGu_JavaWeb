package servlet;

import bean.Forecast;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForecastServlet extends HttpServlet{
//房屋估价
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String city = request.getParameter("city");
		request.setAttribute("city",city);
		String district =request.getParameter("district");
		request.setAttribute("district",district);
		float area = Float.parseFloat(request.getParameter("area"));
		request.setAttribute("area",area);
		String chaoxiang =request.getParameter("chaoxiang");
		request.setAttribute("chaoxiang",chaoxiang);
		String zhuangtai =request.getParameter("zhuangtai");
		request.setAttribute("zhuangtai",zhuangtai);
		int height =Integer.parseInt(request.getParameter("height"));
		request.setAttribute("height",height);

		//获取网页输入值
		Forecast fc=new Forecast();//封装
		fc.setFcity(city);
		fc.setFdistrict(district);
		fc.setArea(area);
		fc.setChaoxiang(chaoxiang);
		fc.setZhuangtai(zhuangtai);
		fc.setHeight(height);

		System.out.println("hello");

		String Model = "郑州高新区随机森林模型.py";
		String[] args = new String[] { "E:\\Anaconda3\\envs\\Sklearn\\python.exe",
				"E:\\GitProjects\\Sklearn\\链家房价预估\\"+Model,
				String.valueOf(70),
				String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(0),
				String.valueOf(1), String.valueOf(0), String.valueOf(0),
				String.valueOf(1), String.valueOf(0), String.valueOf(0),
				"GaoXin_ForestModel.model",
		};
		Process pr=Runtime.getRuntime().exec(args);
		try {
			System.out.println(pr.waitFor());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BufferedReader in=new BufferedReader(new InputStreamReader(pr.getInputStream(),"GBK"));
		BufferedReader stderrReader = new BufferedReader(new InputStreamReader(pr.getErrorStream(),"GBK"));
		String myString = null;
		while((myString=in.readLine())!=null)
			System.out.println(myString);

//        System.out.println("ERROR");
		while ((myString = stderrReader.readLine()) != null) {
			myString = "100";
			System.out.println(myString);
		}
		
		request.setAttribute("price",myString);
		ServletContext sc=this.getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/jm3.jsp");
		rd.forward(request, response);
		//response.sendRedirect("jm2.jsp")
	}
 
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
