package com.veljko.webshop.product;

import com.veljko.webshop.customer.Customer;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 45, message = "Name must be between 4 and 45 characters")
    private String name;

    @NotBlank
    @Size(min = 10, max = 300, message = "Description must be between 10 and 300 characters")
    private String description;

    @NotNull
    @Min(value = 1, message = "At least one product is required")
    private int stock;

    @NotNull
    @Min(value = 10, message = "Price must be larger then 10")
    private int price;

    @NotBlank
    private String image;

    @Column(name = "times_sold")
    private int timesSold;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sales",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private Set<Customer> customers;

    public Product() {
    }

    public Product(String name, String description, int stock, int price, String image, int timesSold) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.image = image;
        this.timesSold = timesSold;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return "/images/" + image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTimesSold() {
        return timesSold;
    }

    public void setTimesSold(int timesSold) {
        this.timesSold = timesSold;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", timesSold=" + timesSold +
                ", customers=" + customers +
                '}';
    }
}
