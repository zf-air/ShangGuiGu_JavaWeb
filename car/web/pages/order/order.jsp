<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <span class="wel_word">我的订单</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>


</div>

<div id="main">
    <table>
        <tr>
            <td>用户名</td>
            <td>汽车名</td>
            <td>租赁日期</td>
            <td>租赁天数</td>
            <td>租赁价格</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.zulinRecords}" var="zulinRecord">
            <tr>
                <td><input name="username" type="text" value="${zulinRecord.username}"/></td>
                <td><input name="carname" type="text" value="${zulinRecord.carname}"/></td>
                <td><input name="date" type="text" value="${zulinRecord.date}"/></td>
                <td><input name=days" type="text" value="${zulinRecord.days}"/></td>
                <td><input name="totalprice" type="text" value="${zulinRecord.totalprice}"/></td>
                <c:if test="${sessionScope.action == 'zulinNoGuihuan'}">
                    <td>
                        <a href="${pageContext.request.contextPath}/guihuanServlet?action=guihuan&username
							=${zulinRecord.username}&carname=${zulinRecord.carname}">归还</a>
                    </td>
                </c:if>
                <c:if test="${sessionScope.action == 'zulinAndGuihuan'}">
					<td>订单已完成</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>