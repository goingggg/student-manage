<%@ page import="java.util.List" %>
<%@ page import="com.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/6
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>all info</title>
  </head>
  <body>
    <table border="1px">
        <tr>
            <th>no</th>
            <th>name</th>
            <th>age</th>
            <th>address</th>
            <th>oper</th>
        </tr>
      <%
           List<StudentBean> students= (List<StudentBean>) request.getAttribute("students");
            for (StudentBean student:students){
        %>

          <tr>
              <td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
            <td><%=student.getSname()%></td>
            <td><%=student.getSage()%></td>
            <td><%=student.getSaddress()%></td>
            <td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>" >">del</a></td>
          </tr>
      <%
      }

      %>
    </table>
  <a href="add.jsp">addPag</a>
  <style type="text/css">
      a {text-decoration: none}
  </style>
  </body>
</html>
