package com.zf.web;


import com.zf.pojo.Car;
import com.zf.pojo.Page;
import com.zf.service.CarService;
import com.zf.service.impl.CarServiceImpl;
import com.zf.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarServlet extends BaseServlet {

    private CarService carService = new CarServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Car> page = carService.page(pageNo,pageSize);

        page.setUrl("manager/carServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/car_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        1、获取请求的参数==封装成为Book对象
        Car car = WebUtils.copyParamToBean(req.getParameterMap(),new Car());
//        2、调用BookService.addBook()保存图书
        carService.addCar(car);
//        3、跳到图书列表页面

        resp.sendRedirect(req.getContextPath() + "/manager/carServlet?action=page");

    }



    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数id，图书编程
        String name = req.getParameter("name");
//        2、调用bookService.deleteBookById();删除图书
        carService.deleteCarByName(name);
//        3、重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/carServlet?action=page");
    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、获取请求的参数==封装成为Car对象
        Car car = WebUtils.copyParamToBean(req.getParameterMap(),new Car());
//        2、调用BookService.updateCar( car );修改图书
        carService.updateCar(car);
//        3、重定向回汽车列表管理页面
//        地址：/工程名/manager/carServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/carServlet?action=page");
    }



    protected void getCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数图书编号
        String name = req.getParameter("name");
        //2 调用bookService.queryBookById查询图书
        Car car = carService.queryCarByName(name);
        //3 保存到图书到Request域中
        req.setAttribute("car", car) ;
        String action = "update";
        req.setAttribute("action", action) ;
        //4 请求转发到。pages/manager/car_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/car_edit.jsp").forward(req,resp);
    }



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过CarService查询全部图书
        List<Car> cars = carService.queryCars();
        //2 把全部图书保存到Request域中
        req.setAttribute("Cars", cars);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/car_manager.jsp").forward(req,resp);
    }

}
