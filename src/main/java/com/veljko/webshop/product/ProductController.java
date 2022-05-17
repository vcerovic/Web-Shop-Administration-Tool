package com.veljko.webshop.product;

import com.veljko.webshop.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

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
    public String listAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        Product mostSoldProduct = productService.findMostSoldProduct();
        Product mostExpensiveProduct = productService.findMostExpensiveProduct();
        Product mostStockProduct = productService.findMostStockProduct();
        long totalProducts = productService.countAllProducts();

        model.addAttribute("products", products);
        model.addAttribute("most_sold_product", mostSoldProduct);
        model.addAttribute("most_expensive_product", mostExpensiveProduct);
        model.addAttribute("most_stock_product", mostStockProduct);
        model.addAttribute("total_products", totalProducts);

        return "product/products";
    }

    //SHOW NEW PRODUCT FORM (/products/new)
    @GetMapping("/new")
    public String showAddProductForm(Model model) {
        return "product/productForm";
    }

    //SAVE PRODUCT (/products)
    @PostMapping
    public ResponseEntity<String> saveProduct(@Valid @ModelAttribute("product") Product product, @RequestParam("image_file") MultipartFile multipartFile) {
        return productService.saveProduct(product, multipartFile);
    }

    //DELETE PRODUCT (/products/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Integer id) {
        try {
            return productService.deleteProductById(id);
        } catch (ProductNotFoundException exc) {
            return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
        }

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
