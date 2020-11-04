package test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Response1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("post response's content!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //解决中文乱码问题
//        resp.setContentType("text/html;charset=UTF-8");

//        //给浏览器写内容
//        PrintWriter writer = resp.getWriter();
//        writer.write("get response's content!!哈哈");

        //跳转到另一个界面
        req.getRequestDispatcher("/form.html").forward(req, resp);
    }
}
