<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="/css/style.css" />
    </head>
    <body>
          <div id="wrapper">
                <c:set var="menu" value="sales" scope="request"/>
                 <%@ include file="../components/menu.jsp" %>
                      <div class="content-container">
                        <table class="content-table">
                          <thead>
                            <tr>
                              <th>Sale ID</th>
                              <th>Customer ID</th>
                              <th>Product ID</th>
                              <th>Time</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="sale" items="${sales}">
                              <tr>
                                <td>${sale.id}</td>
                                <td>${sale.customerId}</td>
                                <td>${sale.productId}</td>
                                <td>${sale.time}</td>
                              </tr>
                            </c:forEach>
                          </tbody>
                        </table>


                      </div>
                    </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>