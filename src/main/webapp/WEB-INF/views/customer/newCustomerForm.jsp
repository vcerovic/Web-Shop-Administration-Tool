<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add new customer</title>
        <link rel="stylesheet" href="/css/style.css" />
        <script defer type="module" src="/js/customer/customers.js"></script>
    </head>

    <body>
          <div id="wrapper">
                    <c:set var="menu" value="new_customer" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                      <div class="title">Add new customer</div>

                      <form action="/customers" method="POST" id="customer_form">
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
                    </div>
                  </div>

           </div>

            <%@ include file="../components/footer.jsp" %>

            <script
              src="https://kit.fontawesome.com/408283dcd0.js"
              crossorigin="anonymous"
            ></script>
            <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    </body>
</html>