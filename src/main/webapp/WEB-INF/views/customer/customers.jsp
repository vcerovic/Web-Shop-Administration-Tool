<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
        <link rel="stylesheet" href="/css/style.css" />
    </head>
    <body>
          <div id="wrapper">
                 <%@ include file="../components/menu.jsp" %>
                      <div class="content-container">
                        <table class="content-table">
                          <thead>
                            <tr>
                              <th>Customer ID</th>
                              <th>Name</th>
                              <th>Email</th>
                              <th>Address</th>
                              <th>Purchases</th>
                              <th>Spent</th>
                              <th>Actions</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="customer" items="${customers}">
                              <tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.email}</td>
                                <td>${customer.address}</td>
                                <td>${customer.purchases}</td>
                                <td>${customer.spent}</td>
                               <td>
                                  <a href="" class="edit-btn"
                                    ><i class="fa-solid fa-pen-to-square"></i
                                  ></a>
                                  <a href="" class="delete-btn"
                                    ><i class="fa-solid fa-trash"></i
                                  ></a>
                                </td>
                              </tr>
                            </c:forEach>
                          </tbody>
                        </table>

                        <aside id="stats">
                          <div class="stats-card">
                            <i class="fa-solid fa-hand-holding-dollar"></i>
                            <div class="stats-info">
                              <p class="stats-title">Most spent:</p>
                              <h1>${customer_spent.spent}</h1>
                              <p>${customer_spent.email}</p>
                            </div>
                          </div>

                          <div class="stats-card">
                            <i class="fa-solid fa-truck"></i>
                            <div class="stats-info">
                              <p class="stats-title">Most purchases:</p>
                               <h1>${customer_purchase.purchases}</h1>
                               <p>${customer_purchase.email}</p>
                            </div>
                          </div>
                              <div class="stats-card">
                                  <i class="fa-solid fa-users"></i>
                                  <div class="stats-info">
                                  <p class="stats-title">Total Customers:</p>
                                    <h1>${total_customers}</h1>
                               </div>
                           </div>
                        </aside>
                      </div>
                    </div>

            <%@ include file="../components/footer.jsp" %>

            <script
              src="https://kit.fontawesome.com/408283dcd0.js"
              crossorigin="anonymous"
            ></script>
    </body>
</html>