package com.zf.web;

import com.zf.pojo.Car;
import com.zf.pojo.User;
import com.zf.pojo.ZulinRecord;
import com.zf.service.CarService;
import com.zf.service.RecordService;
import com.zf.service.impl.CarServiceImpl;
import com.zf.service.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{
    private RecordService recordService = new RecordServiceImpl();
    private CarService carService = new CarServiceImpl();

    protected void getZulinNoGuihuanRecordsByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        //查询用户未完成的订单信息
        List<ZulinRecord> zulinRecords = recordService.queryZulinNoGuihuanRecordsByUser(user.getUsername());
        //保存订单信息到Request域中
        req.getSession().setAttribute("zulinRecords", zulinRecords) ;
        //设置action
        req.getSession().setAttribute("action","zulinNoGuihuan");
        //请求转发到/pages/order/order.jsp页面
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    protected void getZulinAndGuihuanRecordsByUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        //查询用户已完成的订单
        List<ZulinRecord> zulinRecords = recordService.queryZulinAndGuihuanRecordsByUser(user.getUsername());
        //保存订单信息到Request域中
        req.getSession().setAttribute("zulinRecords", zulinRecords) ;
        //设置action
        req.getSession().setAttribute("action","zulinAndGuihuan");
        //请求转发到/pages/order/order.jsp页面
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    protected void getZulinAllRecords(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的订单信息
        List<ZulinRecord> zulinRecords = recordService.queryZulinAllRecords();
        //保存订单信息到Request域中
        req.getSession().setAttribute("zulinRecords", zulinRecords) ;
        //请求转发到/pages/order/order.jsp页面
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    protected void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String username = req.getParameter("username");
        String carname = req.getParameter("carname");
        String date = req.getParameter("date");
        String state = req.getParameter("state");
        int days = Integer.parseInt(req.getParameter("days"));
        double totalprice;
        Car car = carService.queryCarByName(carname);
        totalprice = car.getPrice()*days;

        //封装成对象
        ZulinRecord zulinRecord = new ZulinRecord(username,carname,date,days,totalprice,state);
        //调用service修改数据
        recordService.updateOrder(zulinRecord);
        //请求转发到/pages/order/order.jsp页面
        req.getRequestDispatcher("/pages/manager/order_edit_success.jsp").forward(req,resp);
    }

}
