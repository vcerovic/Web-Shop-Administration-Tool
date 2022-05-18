package com.veljko.webshop.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    //SHOW ALL SALES
    @GetMapping
    public String listAllSales(Model model) {
        List<Sale> sales = saleService.getAllSales();

        model.addAttribute("sales", sales);

        return "sale/sales";
    }

    //SHOW NEW SALE FORM (/sales/new)
    @GetMapping("/new")
    public String showAddSaleForm(Model model) {

        return "sale/saleForm";
    }


    //CREATE NEW SALE (/sales)
    @PostMapping
    public ResponseEntity<String> saveSale(@RequestParam("customer_id") Integer customerId,
                                           @RequestParam("product_id") Integer productId) {
        return saleService.saveSale(customerId, productId);
    }
}
