<%@ page import="com.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/7
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/textAlign.css">
<html>
<head>
    <title>studentInfo</title>
</head>
<body>
<%
    StudentBean student=(StudentBean) request.getAttribute("student");
%>
    <form action="UpdateStudentServlet">
        <fieldset>
            <label for="sno" >id:</label>
            <input type="text" id="sno" name="sno" value="<%=student.getSno()%>" readonly="readonly"/> <br>

            <label for="sname" > name:</label>
            <input type="text" id="sname" name="sname" value="<%=student.getSname()%>"/><br>

            <label for="sage" > age:</label>
            <input type="text" id="sage" name="sage" value="<%=student.getSage()%>"/><br>

            <label for="saddress" > address:</label>
            <input type="text" id="saddress" name="saddress" value="<%=student.getSaddress()%>"/><br>
             <label for="update" > </label>
            <input type="submit" id="update" value="update"/>&nbsp;&nbsp;
            <a href="allInfo" >quit</a>
        </fieldset>
    </form>

</body>
</html>
