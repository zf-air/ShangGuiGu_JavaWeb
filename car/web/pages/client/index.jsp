<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>汽车租赁</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <Script type="text/javascript">
        $(function () {
            $("button.zulin").click(function () {
                /**
                 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
                 * @type {jQuery}
                 */
                let carname = $(this).attr("carname");
                location.href = "http://localhost:8080/car/zulinServlet?action=zulin&carname=" + carname;
            });
        });
    </Script>

</head>
<body>

<div id="header">
    <img class="logo_img" width="150" height="80" alt="" src="static/img/logo.jpg">
    <span class="wel_word">汽车租赁</span>
    <div>
        <%--如果用户还没有登录，显示     【登录 和注册的菜单】 --%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临young帆汽车租赁公司</span>
            <a href="${pageContext.request.contextPath}/orderServlet?action=getZulinNoGuihuanRecordsByUser">未归还订单</a>
            <a href="${pageContext.request.contextPath}/orderServlet?action=getZulinAndGuihuanRecordsByUser">历史订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;&nbsp;
        </c:if>

        <a href="pages/admin/login.jsp">后台管理</a>
    </div>
</div>

<div id="main">
    <div id="car">
        <div class="car_cond">
            <div id="page_price" align="center" >
                <form action="client/carServlet" method="get">
                    <input type="hidden" name="action" value="pageByPrice">
                    价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                    <input id="max" type="text" name="max" value="${param.max}"> 元
                    <input type="submit" value="查询"/>
                </form>
            </div>
            <div id="page_type" align="center" >
                <form action="client/carServlet" method="get">
                    <input type="hidden" name="action" value="pageByType">
                    类型：
                    <input id="type" type="text" name="type" value="${param.type}">
                    <input type="submit" value="查询"/>
                </form>
            </div>
        </div>
        <c:forEach items="${requestScope.page.items}" var="car">
            <div class="b_list" style="padding-top: 40px">
                <div class="img_div">
                    <img class="car_img" width="150" height="120" alt="" src="${car.img_path}"/>
                </div>
                <div class="car_info">
                    <div class="car_name">
                        <span class="sp1">车名:</span>
                        <span class="sp2">${car.name}</span>
                    </div>
                    <div class="car_type">
                        <span class="sp1">类型:</span>
                        <span class="sp2">${car.type}</span>
                    </div>
                    <div class="car_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${car.price}</span>
                    </div>
                    <div class="car_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${car.stock}</span>
                    </div>
                    <div class="car_add">
                        <button carname="${car.name}" class="zulin">租赁</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<%--静态包含分页条--%>
<%@include file="/pages/common/page_nav.jsp" %>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>