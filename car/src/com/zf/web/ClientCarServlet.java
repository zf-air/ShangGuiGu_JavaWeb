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

public class ClientCarServlet extends BaseServlet {

    private CarService carService = new CarServiceImpl();

    /**
     * 处理分页功能
     *
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
        Page<Car> page = carService.page(pageNo, pageSize);
        page.setUrl("client/carServlet?action=page");
        //3 保存Page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到/pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Car> page = carService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/carServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String type = req.getParameter("type");
        //如果type为空
        if(type==null||"".equals(type)){
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Car> page = carService.pageByType(pageNo, pageSize, type);

        StringBuilder sb = new StringBuilder("client/carServlet?action=pageByType");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("type") != null) {
            sb.append("&type=").append(req.getParameter("type"));
        }

        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        req.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
