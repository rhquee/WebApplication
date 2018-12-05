<%--
  Created by IntelliJ IDEA.
  User: kfrak
  Date: 15.08.2018
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello You!</title>
    <link rel="stylesheet" type="text/css" href="/resources/web.css">
</head>

<body>
  <p>Enter your name below to allow the site to welcome you</p>
  <form name="form" method="post" action="/hello">
      <p>
        Your name is:
        <input type="text" name="name">
        <button name="submit">OK</button>
      </p>
  </form>

</body>
</html>
