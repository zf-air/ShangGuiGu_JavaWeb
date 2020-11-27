package com.zf.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取要下载的文件名
        String downloadFileName = "2.jpg";
//        downloadFileName = URLEncoder.encode(downloadFileName, StandardCharsets.UTF_8);
//        2.读取要下载文件的内容
        ServletContext servletContext = getServletContext();
//        获取要下载的文件类型
        String mimetype = servletContext.getMimeType(downloadFileName);
        System.out.println("下载的文件类型:"+mimetype);
//        4.回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimetype);
//        5.告诉客户端收到的数据是用于下载使用
//        Content-Disposition响应头，表示收到的文件怎么处理
//        attachment表示附件，表示下载使用
//        filename=表示指定下载的文件名
//        resp.setHeader("Content-Disposition","attachment;filename="+ downloadFileName) ;
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("中国.jpg", StandardCharsets.UTF_8));
//        斜杠映射到web目录下
        InputStream resourceAsStream = servletContext.getResourceAsStream(downloadFileName);
//        获取相应的输出流
        OutputStream outputStream = resp.getOutputStream();
//        3.把下载内容传给客户端
//        读取输入流的内容，赋值给输出流,输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
