<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改成功</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp" %>


	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color: red;
		}
	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" width="150" height="80" src="static/img/logo.jpg">


</div>

<div id="main">

	<h1>
		修改成功
		<a href="${pageContext.request.contextPath}/index.jsp">转到主页</a>
		<a href="${pageContext.request.contextPath}/orderServlet?action=getZulinAllRecords">返回订单管理</a>
	</h1>

</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>