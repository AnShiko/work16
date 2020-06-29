package com.geekbrains.work16.controllers;


import com.geekbrains.work16.entities.Product;
import com.geekbrains.work16.entities.Selection;
import com.geekbrains.work16.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showProductsList(Model model, @ModelAttribute(value = "selection") Selection selection,
                                   @RequestParam(name = "page", required = false) Integer page, @PathVariable String id) {
        if (page == null)
            page = 0;
        List<Product> content = productsService.getAllProducts(selection, page).getContent();
        model.addAttribute("products", content);
        model.addAttribute("selection", selection);
        return "products";

        @GetMapping("/add")
        public String addProduct(Model model) {
            model.addAttribute("product", new Product());
            return "shopWindow";
        }

        @GetMapping("/edit")
        public String editOneProduct(Model model, @PathVariable(value = "id") {
            model.addAttribute("product", productsService.getById(id));
            return "shopWindow";
        }

        @GetMapping("/show/{id}")
        public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
            model.addAttribute("product", productsService.getById(id));
            return "cartWindow";
        }

        @PostMapping("/save")
        public String saveProduct(@ModelAttribute("product") Product product) {
            productsService.save(product);
            return "redirect:/products";
        }

        @GetMapping("/delete/{id}")
        public String editOneProduct(@PathVariable(value = "id") Long id) {
            productsService.delete(id);
            return "redirect:/products";
        }
    }