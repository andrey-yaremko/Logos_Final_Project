<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 07.07.2021
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 403</title>
</head>
<body>
<div>
    <div>
        <h3>No permission to access page!  </h3>
    </div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign in as different user"/>
        <input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
    </form>

</div>
</body>
</html>
