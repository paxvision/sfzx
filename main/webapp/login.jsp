<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: I am master
  Date: 2017/5/4
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="login.do">
    <form>
             username<input type="text" name="username"/></br>
             password<input type="password" name="password"/></br>
                     <input type="submit" value="submit"/>
                     <input type="reset" value="reset"/>
    </form>
</form>
</body>
</html>
