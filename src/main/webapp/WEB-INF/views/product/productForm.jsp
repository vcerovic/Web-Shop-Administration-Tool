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
                    <c:set var="menu" value="new_product" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                      <div class="title">Add new product</div>
                          <form action="/products" method="POST" id="new_product_form">
                            <div class="field">
                               <input type="text" name="name" id="name" placeholder=" ">
                               <label for="name">Name</label>
                               <div class="error"></div>
                             </div>
                             <div class="field">
                               <input type="number" name="stock" id="stock" placeholder=" ">
                               <label for="stock">Stock</label>
                               <div class="error"></div>
                             </div>
                             <div class="field">
                               <input type="number" name="price" id="price" placeholder=" ">
                               <label for="price">Price</label>
                               <div class="error"></div>
                             </div>
                              <div class="field textarea-field">
                                  <textarea id="description" name="description" rows="4" cols="30" placeholder=" "></textarea>
                                  <label for="description">Description:</label>
                              </div>
                              <div class="field image-field">
                                  <input type="file" name="image" id="image" class="input_file"/>
                                  <label for="image">Choose a image</label>
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
    </body>
</html>