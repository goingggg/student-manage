<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/6
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/textAlign.css">

<html>
<head>
    <title>add student</title>
</head>
<body>
<script type="text/javascript">
    function check() {
        var sno=$("#sno").val();
        var sname=$("#sname").val();
        var sage=$("#sage").val();
        var saddress=$("#saddress").val();

        if (sno<1) {
            alert("student number must then 1")
            return false;
        }
        if (!(sname.length>1&sname.length<5)) {
            alert("name have question")
            return false;
        }
        if (sage<0||sage>100) {
            alert("age 1-100")
            return false;
        }
        if (saddress.length=0) {
            alert("address not null")
            return false;
        }

    }
</script>
<form name="form1" action="add" method="post" onsubmit="return check()">
    <fieldset>
        <label for="sno" >id:</label>
        <input type="text" name="sno" id="sno"/> <br>
        <label for="sname" > name:</label>
        <input type="text" name="sname" id="sname"/><br>
        <label for="sage" > age:</label>
        <input type="text" name="sage" id="sage"/><br>
        <label for="saddress" > address:</label>
        <input type="text" name="saddress" id="saddress"/><br>
        <label for="update" > </label>
        <input type="submit" id="update" value="add"/>
    </fieldset>
</form>

</body>
</html>
