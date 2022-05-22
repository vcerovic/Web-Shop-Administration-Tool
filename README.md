<h1 align="center">Web Shop Administration Tool</h1>

![Admin Page Products](https://i.ibb.co/zXj3sWQ/products.png)

<br>

## Content
  1. [Info](#Info)
  2. [Technologies](#Technologies)
  3. [User guide](#Guide)
  4. [Functionality](#Functionality)
  5. [Database](#Database)


<br>
<br>

## <a name="Info"></a> Project Info

Web Shop Administration Tool where you can view, create, delete, and edit your customers and products.
You can make sales between them. With each entity comes different statistical data.
Data is validated both on frontend and backend side.

<br>
<br>

## <a name="Technologies"></a> Technologies
<ul>
  <li>Backend
     <ul>
       <li>Java</li>
       <li>Spring boot</li>
       <li>Spring Data JPA</li>
       <li>Hibernate</li>
       <li>MySQL</li>
    </ul>
  </li>
  <li>Frontend
     <ul>
       <li>JSP - Java Server Pages</li>
       <li>Javascript</li>
       <li>Axios (for requests)</li>
       <li>SweetAlert2 (for alerts)</li>
       <li>SCSS</li>
    </ul>  
  </li>
</ul>


<br>
<br>

## <a name="Guide"></a> User guide
1. You need to execute a script for creating the database that is in the file `mysql/webshop.sql`
2. Modify the database connection configuration to suit your settings. All settings can be found in the file `src/main/resources/application.properties`. 
3. Finally, you can start application by running `main()` method inside `src/main/java/com/veljko/webshop/WebshopApplication.java` file.


<br>
<br>

## <a name="Functionality"></a> Functionality

<br>

>**1.** View all customers.

<br>

![All Customers](https://i.ibb.co/jWp8gDz/customers.png)

<br>

>**2.** Manage products.

<br>

![Manage Products](https://i.ibb.co/gt6LTL4/add-product.png)

<br>

>**3.** Manage customers.

<br>

![Manage Customers](https://i.ibb.co/R4W6nNq/add-customer.png)


<br>

>**4.** Make sales.

<br>


![Manage Sales](https://i.ibb.co/dQjXhSt/sales.png)

<br>
<br>

## <a name="Database"></a> Database Diagram

![Database Diagram](https://i.ibb.co/BNBKbS2/er-diagram.png)
