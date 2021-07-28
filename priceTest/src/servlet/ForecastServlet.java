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
import java.util.ArrayList;
import java.util.Arrays;

public class ForecastServlet extends HttpServlet {
    //房屋估价
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String city = request.getParameter("city");
        request.setAttribute("city", city);
        String district = request.getParameter("district");
        request.setAttribute("district", district);
        int area = Integer.parseInt(request.getParameter("area"));
        request.setAttribute("area", area);
        String chaoxiang = request.getParameter("chaoxiang");
        request.setAttribute("chaoxiang", chaoxiang);
        String zhuangtai = request.getParameter("zhuangtai");
        request.setAttribute("zhuangtai", zhuangtai);
        int height = Integer.parseInt(request.getParameter("height"));
        request.setAttribute("height", height);

        //获取网页输入值
        Forecast fc = new Forecast();//封装
        fc.setFcity(city);
        fc.setFdistrict(district);
        fc.setArea(area);
        fc.setChaoxiang(chaoxiang);
        fc.setZhuangtai(zhuangtai);
        fc.setHeight(height);

        ArrayList<Integer> arr_chaoxiang = new ArrayList<Integer>(Arrays.asList(0,0,0,0));
        ArrayList<String> arr_chaoxiang_test = new ArrayList<String>(Arrays.asList("东","南","西","北"));
        int chaoxiang_cnt = 0;
        for(int i=0;i<4;i++){
            if(fc.getChaoxiang().equals(arr_chaoxiang_test.get(i))){
                break;
            }
            chaoxiang_cnt++;
        }
        arr_chaoxiang.set(chaoxiang_cnt, 1);

        ArrayList<Integer> arr_zhuangxiu = new ArrayList<Integer>(Arrays.asList(0,0,0));
        ArrayList<String> arr_zhuangxiu_test = new ArrayList<String>(Arrays.asList("毛坯","简装","精装"));
        int zhuangxiu_cnt = 0;
        for(int i=0;i<3;i++){
            if(fc.getZhuangtai().equals(arr_zhuangxiu_test.get(i))){
                break;
            }
            zhuangxiu_cnt++;
        }
        arr_zhuangxiu.set(zhuangxiu_cnt, 1);

        String PythonName = "房价预测模型.py";
        String Model = "GaoXin_ForestModel.model";

        if((fc.getFcity().equals("郑州")) && (fc.getFdistrict().equals("二七"))){
            Model = "ErQi_ForestModel.model";
        }

        String[] args = new String[]{"E:\\Anaconda3\\envs\\Sklearn\\python.exe",
                "E:\\GitProjects\\Sklearn\\链家房价预估\\" + PythonName,
                String.valueOf(area),
                String.valueOf(arr_chaoxiang.get(0)), String.valueOf(arr_chaoxiang.get(1)),
                String.valueOf(arr_chaoxiang.get(2)), String.valueOf(arr_chaoxiang.get(3)),
                String.valueOf(arr_zhuangxiu.get(0)), String.valueOf(arr_zhuangxiu.get(1)),
                String.valueOf(arr_zhuangxiu.get(2)),
                String.valueOf(1), String.valueOf(0), String.valueOf(0),
                Model,
        };
        Process pr = Runtime.getRuntime().exec(args);
        try {
            System.out.println(pr.waitFor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
        BufferedReader stderrReader = new BufferedReader(new InputStreamReader(pr.getErrorStream(), "GBK"));
        String myString = null;
        String score = "86.5";
        while ((myString = in.readLine()) != null) {
			score = myString;
        	System.out.println(myString);
		}

//        System.out.println("ERROR");
        while ((myString = stderrReader.readLine()) != null) {
            System.out.println(myString);
        }

        score+="万";
        request.setAttribute("price", score);
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jm3.jsp");
        rd.forward(request, response);
        //response.sendRedirect("jm2.jsp")
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
