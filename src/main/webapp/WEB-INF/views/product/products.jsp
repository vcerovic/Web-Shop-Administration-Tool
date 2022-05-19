<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="/css/style.css" />
         <script defer type="module" src="/js/product/products.js"></script>
    </head>
    <body>
          <div id="wrapper">
                <c:set var="menu" value="products" scope="request"/>
                 <%@ include file="../components/menu.jsp" %>
                      <div class="content-container">
                        <table class="content-table">
                          <thead>
                            <tr>
                              <th>Product ID</th>
                              <th>Image</th>
                              <th>Name</th>
                              <th>Description</th>
                              <th>Stock</th>
                              <th>Price</th>
                              <th>Times sold</th>
                              <th>Actions</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="product" items="${products}">
                              <tr>
                                <td>${product.id}</td>
                                <td class="image-td">
                                   <img src="/images/${product.image}" alt="${product.name}">
                                </td>
                                <td title="${product.name}" class="ellipsis">${product.name}</td>
                                <td title="${product.description}" class="ellipsis">${product.description}</td>
                                <td class=${(product.stock < 1 ? "out_of_stock" : "")}>${product.stock}</td>
                                <td>${product.price}$</td>
                                <td>${product.timesSold}</td>
                                <td>
                                  <a href="/products/${product.id}/edit" class="edit-btn"
                                    ><i class="fa-solid fa-pen-to-square"></i
                                  ></a>
                                  <a href="/products/${product.id}" class="delete-btn"
                                    ><i class="fa-solid fa-trash"></i
                                  ></a>
                                </td>
                              </tr>
                            </c:forEach>
                          </tbody>
                        </table>

                        <aside id="stats">
                          <div class="stats-card">
                            <i class="fa-solid fa-medal"></i>
                            <div class="stats-info">
                              <p class="stats-title">Most sold:</p>
                              <h1>${most_sold_product.timesSold}</h1>
                              <p>${most_sold_product.name}</p>
                            </div>
                          </div>

                          <div class="stats-card">
                            <i class="fa-solid fa-money-bill-trend-up"></i>
                            <div class="stats-info">
                              <p class="stats-title">Most expensive:</p>
                               <h1>${most_expensive_product.price}$</h1>
                               <p>${most_expensive_product.name}</p>
                            </div>
                          </div>
                              <div class="stats-card">
                                  <i class="fa-solid fa-box-open"></i>
                                  <div class="stats-info">
                                  <p class="stats-title">Most in stock:</p>
                                    <h1>${most_stock_product.stock}</h1>
                                    <p>${most_stock_product.name}</p>
                               </div>
                           </div>
                                <div class="stats-card">
                                  <i class="fa-solid fa-truck"></i>
                                  <div class="stats-info">
                                    <p class="stats-title">Total products:</p>
                                     <h1>${total_products}</h1>
                                  </div>
                                </div>

                        </aside>
                      </div>
                    </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>