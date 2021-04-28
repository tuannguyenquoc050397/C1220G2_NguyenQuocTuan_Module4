<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 28-Apr-21
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator Super Vip</h1>

<form action="/calculator">
    <input type="number" name="number1" placeholder="number1">
    <input type="number" name="number2" placeholder="number2"> <br>
    <input type="submit" name="actionClient" value="add">
    <input type="submit" name="actionClient" value="sub">
    <input type="submit" name="actionClient" value="mul">
    <input type="submit" name="actionClient" value="div">
</form>
<br>
<h3>${result}</h3>

<h1>${a}</h1>
<h1>${s}</h1>

</body>
</html>
