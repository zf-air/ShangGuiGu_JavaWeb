package test;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet{
    public HelloServlet() {
        System.out.println("1 servlet constructor");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 servlet init");
    }

    @Override
    public ServletConfig getServletConfig() {

        return null;
    }

    @Override
    //处理请求和响应
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 hello servlet被响应!");
        // 父类转子类，获取method方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取方式
        String method = httpServletRequest.getMethod();

        if("POST".equals(method)){
            System.out.println("post请求");
        }
        else{
            System.out.println("get请求");
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 servlet destroy");
    }
}
