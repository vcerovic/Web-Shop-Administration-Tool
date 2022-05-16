package com.veljko.webshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //GET ALL PRODUCTS (/products)
    @GetMapping
    public void listAllProducts(Model model) {

    }

    //SHOW NEW PRODUCT FORM (/products/new)
    @GetMapping("/new")
    public void showAddProductForm(Model model) {

    }

    //SAVE PRODUCT (/products)
    @PostMapping
    public void saveProduct(@Valid @ModelAttribute("product") Product product) {

    }

    //DELETE PRODUCT (/products/{id})
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value = "id") Integer id) {

    }


    //SHOW EDIT FORM (/products/{id}/edit)
    @GetMapping("/{id}/edit")
    public void showEditProductForm(@PathVariable(value = "id") Integer id, Model model) {

    }


    //UPDATE PRODUCT (/product)
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable(value = "id") Integer id, @Valid @ModelAttribute("product") Product product) {

    }
}
