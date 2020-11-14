<%@ page import="com.zf.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hi! J.Smith
  Date: 2020/11/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px blue solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(0,"zhangfan",18,"18639832089"));
        list.add(new Student(1,"zhangsan",19,"18639832089"));
        list.add(new Student(2,"zhangchenyu",20,"18639832089"));
    %>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>phone</td>
        </tr>

    <%
        for(Student student:list){
    %>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
        </tr>
    <%
        }
    %>
    </table>
</body>
</html>
