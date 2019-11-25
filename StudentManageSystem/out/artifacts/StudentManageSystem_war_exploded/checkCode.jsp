<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/12
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>验证码</title>
    <script type="text/javascript">
        function reloadCheckCode(){
            $("img").attr("src","img.jsp?t="+(new Date().getTime()));
        }
        $(document).ready(function () {
            $("#checkCodeId").blur(function () {
                var $checkCode=$("#checkCodeId").val();
                $.post(
                    "checkCodeServlet",
                    "checkCode="+$checkCode,
                    function (result) {
                      var resultHtml =$("<img src='"+result+"' height='15' width='15px' >")
                        $("#tip").html(resultHtml);
                    }

                )
            })
            
        })
    </script>
</head>

<body>
验证码：
    <input type="text" name="checkCode" id="checkCodeId" size="4" style="height: 30px;width: 80px">
    <a href="javascript:reloadCheckCode();"><img src="img.jsp"></a>
    <span id="tip" ></span>
</body>
</html>
