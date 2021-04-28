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
<h1>Sandwich Condiments</h1>
<form action="/sandwich" method="post">
    <input type="checkbox" id="sandwich1" name="sandwich1" value="Lettuce">
    <label for="sandwich1"> Lettuce</label>
    <input type="checkbox" id="sandwich2" name="sandwich1" value="Tomato">
    <label for="sandwich2">Tomato</label>
    <input type="checkbox" id="sandwich3" name="sandwich1" value="Mustard">
    <label for="sandwich3"> Mustard</label>
    <input type="checkbox" id="sandwich4" name="sandwich1" value="Sprouts">
    <label for="sandwich4"> Sprouts</label><br><br>
    <hr>
    <input type="submit" value="Submit">
</form>
</body>
</html>
