<%@ page import="com.zf.pojo.ZulinRecord" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>


    <script type="text/javascript">
        function sub_Update(usernameId,carnameId,datId,daysId,totalPriceId,stateId){
            var username = document.getElementById(usernameId).value;
            var carname = document.getElementById(carnameId).value;
            var date = document.getElementById(datId).value;
            var days = document.getElementById(daysId).value;
            var totalPrice = document.getElementById(totalPriceId).value;
            var state = document.getElementById(stateId).value;
            window.location.href="${pageContext.request.contextPath}/orderServlet?action=updateOrder&username="+username+"&carname="+carname+"&date="+date+"&days="+days+"&totalPrice="+totalPrice+"&state="+state;

        }
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" width="150" height="80" src="${pageContext.request.contextPath}/static/img/logo.jpg">
    <span class="wel_word">订单管理系统</span>

    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
        <input type="hidden" name="action" value="updateOrder">
        <table>
            <tr>
                <td>用户名</td>
                <td>汽车名</td>
                <td>租赁日期</td>
                <td>租赁天数</td>
                <td>租赁价格</td>
                <td>状态</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${sessionScope.zulinRecords}" var="zulinRecord" varStatus="i">
                <tr>
                    <td><input id="username${i.index}" type="text" value="${zulinRecord.username}"/></td>
                    <td><input id="carname${i.index}" type="text" value="${zulinRecord.carname}"/></td>
                    <td><input id="dat${i.index}" type="text" value="${zulinRecord.date}"/></td>
                    <td><input id="days${i.index}" type="text" value="${zulinRecord.days}"/></td>
                    <td><input id="totalprice${i.index}" type="text" value="${zulinRecord.totalprice}"/></td>
                    <td><input id="state${i.index}" type="text" value="${zulinRecord.state}"/></td>
                    <td><input id="button${i.index}" type="button" value="修改" onclick="sub_Update('username${i.index}','carname${i.index}','dat${i.index}','days${i.index}','totalprice${i.index}','state${i.index}')"></td>
                </tr>
            </c:forEach>
        </table>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>