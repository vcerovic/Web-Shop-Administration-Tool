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
                              <th>Customer ID</th>
                              <th>Customer Name</th>
                              <th>Email</th>
                              <th>Product ID</th>
                              <th>Product Name</th>
                              <th>Image</th>
                              <th>Price</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="customer" items="${customers}">
                                <c:forEach var="product" items="${customer.products}">
                                  <tr>
                                    <td>${customer.id}</td>
                                    <td>${customer.name}</td>
                                    <td>${customer.email}</td>
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td class="image-td">
                                       <img src="/images/${product.image}" alt="${product.name}">
                                    </td>
                                    <td>${product.price}$</td>
                                  </tr>
                            </c:forEach>
                            </c:forEach>
                          </tbody>
                        </table>


                      </div>
                    </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>