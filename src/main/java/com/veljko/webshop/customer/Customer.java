package com.veljko.webshop.customer;

import com.veljko.webshop.product.Product;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 20, message = "Name must be between 4 and 45 characters")
    private String name;

    @NotBlank
    @Email
    @Size(min = 10, max = 60, message = "Email must be between 10 and 60 characters")
    private String email;

    @NotBlank
    @Size(min = 4, max = 65, message = "Address must be between 4 and 45 characters")
    private String address;

    private int purchases;
    private int spent;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Product> products;

    public Customer() {
    }

    public Customer(String name, String email, String address, int purchases, int spent) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.purchases = purchases;
        this.spent = spent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getSpent() {
        return spent;
    }

    public void setSpent(int spent) {
        this.spent = spent;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", purchases=" + purchases +
                ", spent=" + spent +
                ", products=" + products +
                '}';
    }
}
