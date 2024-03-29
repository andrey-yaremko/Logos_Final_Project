<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 08.07.2021
  Time: 08:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container">


    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="/home" class="w3-bar-item w3-button">Home</a>
        <a href="/create-periodical" class="w3-bar-item w3-button">Create periodical</a>
        <a href="/buckets" class="w3-bar-item w3-button">Bucket</a>
    </div>



    <div style="margin-left: 10%">
        <div class="w3-container w3-teal">
            <h1>Create new periodical</h1>
        </div>
        <div class="w3-container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
                <h2>
                    <a onclick="document.forms['logoutForm'].submit()">Logout</a>
                </h2>
            </c:if>




            <form:form method="POST" action="${contextPath}/addPeriodical"
                       enctype="multipart/form-data">
                <table>

                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name"/></td>
                    </tr>

                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="description"/></td>
                    </tr>

                    <tr>
                        <td>Price</td>
                        <td><input type="number" name="price"/></td>
                    </tr>

                    <tr>
                        <td>Select an image to upload</td>
                        <td><input type="file" name="image"/></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>

                </table>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form:form>


        </div>

    </div>


</div>

</body>
</html>