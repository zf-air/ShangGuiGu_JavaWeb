
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临young帆租赁公司</span>
    <a href="${pageContext.request.contextPath}/orderServlet?action=getZulinNoGuihuanRecordsByUser">未归还订单</a>
    <a href="${pageContext.request.contextPath}/orderServlet?action=getZulinAndGuihuanRecordsByUser">历史订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/index.jsp">返回</a>
</div>