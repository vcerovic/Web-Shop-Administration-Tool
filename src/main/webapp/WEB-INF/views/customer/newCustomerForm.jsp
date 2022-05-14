<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add new customer</title>
        <link rel="stylesheet" href="/css/style.css" />
    </head>

    <body>
          <div id="wrapper">
                    <c:set var="menu" value="new_customer" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                      <div class="title">Login Form</div>

                      <form action="#" method="POST">
                        <div class="field">
                          <input type="text" name="email" id="email" required />
                          <label for="email">Email Address</label>
                        </div>

                        <div class="field">
                          <input type="password" name="password" id="password" required />
                          <label for="password">Password</label>
                        </div>

                        <div class="content">
                        </div>

                        <div class="field">
                          <input class="action-btn" type="submit" value="Login" />
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
    </body>
</html>