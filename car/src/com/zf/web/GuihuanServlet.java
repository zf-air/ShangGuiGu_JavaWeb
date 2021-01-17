package com.zf.web;

import com.zf.pojo.GuihuanRecord;
import com.zf.service.RecordService;
import com.zf.service.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuihuanServlet extends BaseServlet {
    private RecordService recordService = new RecordServiceImpl();

    protected void guihuan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名
        String username = req.getParameter("username");
        //获取汽车名称
        String carname = req.getParameter("carname");
        //获取日期和天数信息
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date1 = new Date(System.currentTimeMillis());
        String date = formatter.format(date1);
        //查询归还记录
        GuihuanRecord guihuanRecord = recordService.queryGuihuanRecordByUserAndCar(username,carname);
        //写入归还记录
        recordService.saveGuihuanRecord(username, carname, date);
        //转到归还界面
        req.getRequestDispatcher("/pages/user/guihuan_success.jsp").forward(req, resp);
    }
}
