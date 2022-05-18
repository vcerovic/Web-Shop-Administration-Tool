<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add new product</title>
        <link rel="stylesheet" href="/css/style.css" />
        <script defer type="module" src="/js/product/productForm.js"></script>
    </head>

    <body>
          <div id="wrapper">
                    <c:set var="menu" value="new_product" scope="request"/>
                        <%@ include file="../components/menu.jsp" %>

            <div class="content-container">
                    <div class="form-container">
                      <c:if test = "${form_type == 'new'}">
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
                                  <div class="error"></div>
                              </div>
                              <input type="hidden" id="image" name="image" value="">

                              <div class="field image-field">
                                  <input type="file" name="image_file" id="image_file" accept="image/png, image/jpeg" class="input_file"/>
                                  <label for="image_file">Choose a image</label>
                                  <div class="error"></div>
                              </div>

                            <div class="content">
                            </div>

                            <div class="field">
                              <input class="action-btn" type="submit" value="Submit" />
                            </div>
                          </form>
                    </div>
                    </c:if>

                     <c:if test = "${form_type == 'edit'}">
                      <div class="title">Edit ${product.name}</div>
                          <form action="/products/${product.id}" method="POST" id="edit_product_form">
                           <input type="hidden" id="product_id" name="product_id" value="${product.id}">
                            <div class="field">
                               <input type="text" name="name" id="name" value=${product.name} placeholder=" ">
                               <label for="name">Name</label>
                               <div class="error"></div>
                             </div>
                             <div class="field">
                               <input type="number" name="stock" id="stock" value=${product.stock} placeholder=" ">
                               <label for="stock">Stock</label>
                               <div class="error"></div>
                             </div>
                             <div class="field">
                               <input type="number" name="price" id="price" value=${product.price} placeholder=" ">
                               <label for="price">Price</label>
                               <div class="error"></div>
                             </div>
                              <div class="field textarea-field">
                                  <textarea id="description" name="description" rows="4" cols="30" placeholder=" ">${product.description}</textarea>
                                  <label for="description">Description:</label>
                                  <div class="error"></div>
                              </div>
                              <input type="hidden" id="image" name="image" value=${product.image}>

                              <div class="field image-field">
                                  <input type="file" name="image_file" id="image_file" accept="image/png, image/jpeg" class="input_file"/>
                                  <label for="image_file">Change ${product.image} image</label>
                                  <div class="error"></div>
                              </div>

                            <div class="content">
                            </div>

                            <div class="field">
                              <input class="action-btn" type="submit" value="Submit" />
                            </div>
                          </form>
                    </div>
                    </c:if>
                  </div>

           </div>

            <%@ include file="../components/footer.jsp" %>
    </body>
</html>