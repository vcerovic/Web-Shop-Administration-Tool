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
                              <th>Customer</th>
                              <th>Product ID</th>
                              <th>Product</th>
                              <th>Image</th>
                              <th>Price</th>
                              <th>Quantity</th>
                              <th>Time</th>
                              <th>Profit</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="customer" items="${customers}">
                             <c:forEach var="sale" items="${customer.sales}">
                                  <tr>
                                    <td class="customer_td">${sale.customer.id}</td>
                                    <td class="customer_td">${sale.customer.name}</td>
                                    <td>${sale.product.id}</td>
                                    <td>${sale.product.name}</td>
                                    <td class="image-td">
                                       <img src="/images/${sale.product.image}" alt="${sale.product.name}">
                                    </td>
                                    <td>${sale.product.price}$</td>
                                    <td class="sale_td">${sale.quantity}</td>
                                    <td class="sale_td">${sale.time}</td>
                                    <td class="sale_td bold">${sale.product.price * sale.quantity}$</td>
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