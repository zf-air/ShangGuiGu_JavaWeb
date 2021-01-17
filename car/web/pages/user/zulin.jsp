<%@ page import="com.zf.pojo.Car" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>汽车租赁</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" width="150" height="80" alt="" src="static/img/logo.jpg">
    <span class="wel_word">汽车租赁</span>
</div>

<div id="main">
    <div align="center" id="car">
        <%Car car = (Car) request.getSession().getAttribute("car_class");%>
        <div align="center" class="c_list" style="padding-top: 40px">
            <div class="img_div">
                <img class="car_img" width="150" height="120" alt="" src="<%=car.getImg_path()%>"/>
            </div>
            <div class="car_info">
                <div class="car_name">
                    <span class="sp1">车名:</span>
                    <span class="sp2"><%=car.getName()%></span>
                </div>
                <div class="car_type">
                    <span class="sp1">类型:</span>
                    <span class="sp2"><%=car.getType()%></span>
                </div>
                <div class="car_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">￥<%=car.getPrice()%></span>
                </div>
                <div class="car_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2"><%=car.getStock()%></span>
                </div>

            </div>
            <form action="${pageContext.request.contextPath}/zulinServlet?action=zulined" method="post">
                <div class="car_amount">
                    <label>
                        天数:<input type="text" name="days">
                    </label>
                </div>
                <input type="submit" value="租赁">
            </form>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>