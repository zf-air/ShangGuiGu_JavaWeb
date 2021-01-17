<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑汽车</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>

		<div id="header">
			<span class="wel_word">编辑汽车</span>

			<%-- 静态包含 manager管理模块的菜单  --%>
			<%@include file="/pages/common/manager_menu.jsp"%>


		</div>
		
		<div id="main">
			<form action="manager/carServlet" method="get">
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="action" value= "${empty param.name ? "add" : "update"}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>类型</td>
						<td>价格</td>
						<td>库存</td>
						<td>图片路径</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="name" type="text" value="${requestScope.car.name}"/></td>
						<td><input name="type" type="text" value="${requestScope.car.type}"/></td>
						<td><input name="price" type="text" value="${requestScope.car.price}"/></td>
						<td><input name="stock" type="text" value="${requestScope.car.stock}"/></td>
						<td><input name="img_path" type="text" value="${requestScope.car.img_path}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
		</div>

		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/footer.jsp"%>

</body>
</html>