package com.zf.web;

import com.zf.pojo.Car;
import com.zf.pojo.User;
import com.zf.service.CarService;
import com.zf.service.RecordService;
import com.zf.service.UserService;
import com.zf.service.impl.CarServiceImpl;
import com.zf.service.impl.RecordServiceImpl;
import com.zf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZulinServlet extends BaseServlet {
    private CarService carService = new CarServiceImpl();
    private UserService userService = new UserServiceImpl();
    private RecordService recordService = new RecordServiceImpl();

    protected void zulin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取汽车名称
        String carname = req.getParameter("carname");
        //获取汽车信息
        Car car = carService.queryCarByName(carname);
        System.out.println(car.getImg_path());
        //封装汽车信息
        req.getSession().setAttribute("car_class", car);
        //转到租赁界面
        req.getRequestDispatcher("/pages/user/zulin.jsp").forward(req, resp);
    }

    protected void zulined(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
        //获取汽车信息
        Car car = (Car) req.getSession().getAttribute("car_class");
        if(car.getStock()<=0){
            //转到租赁界面
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        //获取日期和天数信息
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date1 = new Date(System.currentTimeMillis());
        String date = formatter.format(date1);

        int days = Integer.parseInt(req.getParameter("days"));
        double totalprice = car.getPrice() * days;
        //调用userService保存到数据库
        recordService.saveZulinRecord(user.getUsername(),car.getName(),date,days,totalprice);
        //转到租赁界面
        req.getRequestDispatcher("/pages/user/zulin_success.jsp").forward(req, resp);
    }
}
