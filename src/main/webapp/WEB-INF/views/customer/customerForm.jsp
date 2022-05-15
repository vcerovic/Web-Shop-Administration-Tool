<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add new customer</title>
        <link rel="stylesheet" href="/css/style.css" />
        <script defer type="module" src="/js/customer/customerForm.js"></script>
    </head>

    <body>
          <div id="wrapper">
                    <c:set var="menu" value="new_customer" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                    <c:if test = "${form_type == 'new'}">
                      <div class="title">Add new customer</div>
                          <form action="/customers" method="POST" id="new_customer_form">
                               <div class="field">
                                 <input type="text" name="name" id="name" placeholder=" ">
                                 <label for="name">Name</label>
                                 <div class="error"></div>
                               </div>
                               <div class="field">
                                 <input type="text" name="email" id="email" placeholder=" ">
                                 <label for="email">Email Address</label>
                                 <div class="error"></div>
                               </div>
                               <div class="field">
                                 <input type="text" name="address" id="address" placeholder=" ">
                                 <label for="address">Address</label>
                                 <div class="error"></div>
                               </div>

                            <div class="content">
                            </div>

                            <div class="field">
                              <input class="action-btn" type="submit" value="Submit" />
                            </div>
                          </form>
                         </c:if>

                    <c:if test = "${form_type == 'edit'}">
                      <div class="title">Edit ${customer.name}</div>
                          <form action="/customers/${customer.id}" method="POST" id="edit_customer_form">
                            <input type="hidden" id="customer_id" name="customer_id" value="${customer.id}">
                               <div class="field">
                                 <input type="text" name="name" id="name" value="${customer.name}" placeholder=" ">
                                 <label for="name">Name</label>
                                 <div class="error"></div>
                               </div>
                               <div class="field">
                                 <input type="text" name="email" id="email" value="${customer.email}" placeholder=" ">
                                 <label for="email">Email Address</label>
                                 <div class="error"></div>
                               </div>
                               <div class="field">
                                 <input type="text" name="address" id="address" value="${customer.address}" placeholder=" ">
                                 <label for="address">Address</label>
                                 <div class="error"></div>
                               </div>

                            <div class="content">
                            </div>

                            <div class="field">
                              <input class="action-btn" type="submit" value="Submit" />
                            </div>
                          </form>
                         </c:if>
                    </div>
                  </div>

           </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>