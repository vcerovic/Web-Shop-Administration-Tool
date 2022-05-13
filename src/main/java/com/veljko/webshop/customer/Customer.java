package com.veljko.webshop.customer;

import com.veljko.webshop.product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    private String name, email, address;
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
