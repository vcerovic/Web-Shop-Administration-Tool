<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
        <link rel="stylesheet" href="/css/style.css" />
           <script defer type="module" src="/js/customer/customers.js"></script>
    </head>
    <body>
          <div id="wrapper">
                <c:set var="menu" value="customers" scope="request"/>
                 <%@ include file="../components/menu.jsp" %>
                      <div class="content-container">
                        <table class="content-table">
                          <thead>
                            <tr>
                              <th>Customer ID</th>
                              <th>Name</th>
                              <th>Email</th>
                              <th class="ellipsis">Address</th>
                              <th>Purchases</th>
                              <th>Spent</th>
                              <th>Actions</th>
                            </tr>
                          </thead>
                          <tbody>
                            <c:forEach var="customer" items="${customers}">

                              <tr>
                                <td>${customer.id}</td>
                                <td class="ellipsis" title="${customer.name}">${customer.name}</td>
                                <td class="ellipsis" title="${customer.email}">${customer.email}</td>
                                <td class="ellipsis" title="${customer.address}">${customer.address}</td>
                                <td>${customer.purchases}</td>
                                <td>${customer.spent}</td>
                                <td>
                                  <a href="/customers/${customer.id}/edit" class="edit-btn"
                                    ><i class="fa-solid fa-pen-to-square"></i
                                  ></a>
                                  <a href="/customers/${customer.id}" class="delete-btn"
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
                            </div>
                          </div>

                          <div class="stats-card">
                            <i class="fa-solid fa-piggy-bank"></i>
                            <div class="stats-info">
                              <p class="stats-title">Most purchases:</p>
                               <h1>${customer_purchase.purchases}</h1>
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
    </body>
</html>