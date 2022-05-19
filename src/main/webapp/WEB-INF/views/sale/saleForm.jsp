<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add new sale</title>
        <link rel="stylesheet" href="/css/style.css" />
        <script defer type="module" src="/js/sale/saleForm.js"></script>
    </head>

    <body>
          <div id="wrapper">
                    <c:set var="menu" value="new_sale" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                      <div class="title">Add new sale</div>
                          <form action="/sales" method="POST" id="new_sale_form">
                             <div class="field">
                               <input type="number" name="customer_id" id="customer_id" placeholder=" ">
                               <label for="customer_id">Customer ID:</label>
                               <div class="error"></div>
                             </div>
                            <div class="field">
                               <input type="number" name="product_id" id="product_id" placeholder=" ">
                               <label for="product_id">Product ID:</label>
                               <div class="error"></div>
                             </div>
                              <div class="field">
                               <input type="number" name="quantity" id="quantity" placeholder=" ">
                               <label for="quantity">Quantity:</label>
                               <div class="error"></div>
                             </div>

                            <div class="content">
                            </div>

                            <div class="field">
                              <input class="action-btn" type="submit" value="Make a sale" />
                            </div>
                          </form>
                    </div>
                  </div>

           </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>