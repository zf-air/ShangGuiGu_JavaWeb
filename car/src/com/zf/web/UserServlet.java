package com.zf.web;


import com.zf.pojo.User;
import com.zf.service.UserService;
import com.zf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 注销
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2、重定向到首页（或登录页面）。
        resp.sendRedirect("/car/index.jsp");
    }

    /**
     * 处理登录的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String Model = "郑州高新区随机森林模型.py";
//        调用cmd执行Sklearn环境下的python程序
//        String myCommand="E:\\Anaconda3\\envs\\Sklearn\\python.exe 郑州高新区随机森林模型.py";
//        Process pr=Runtime.getRuntime().exec(myCommand,null,new File("E:\\GitProjects\\ShangGuiGu_JavaWeb\\car\\web\\"));
//        Process pr=Runtime.getRuntime().exec(myCommand,null,new File("E:\\GitProjects\\Sklearn\\链家房价预估\\"));
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
        String myString=null;
        while((myString=in.readLine())!=null)
            System.out.println(myString);

//        System.out.println("ERROR");
        while ((myString = stderrReader.readLine()) != null) {
            System.out.println(myString);
        }

        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(username, password);
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);
            //   跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // 登录 成功
            // 保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", loginUser);
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    /**
     * 处理注册的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String code = req.getParameter("code");

        User user=new User(username,password,sex,age,phone);
//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("sex", sex);
                req.setAttribute("age", age);
                req.setAttribute("phone", phone);

//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userService.registUser(new User(username, password, sex, age, phone));
//        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("sex", sex);
            req.setAttribute("age", age);
            req.setAttribute("phone", phone);

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }


}
