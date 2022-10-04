package com.example.letscode.controller;

import com.example.letscode.models.Product;
import com.example.letscode.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.list(title));
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct() {
        var prod = Product.builder()
                .description("2222")
                .author("ivan")
                .price(123)
                .title("erere")
                .city("msc")
                .build();
        productService.saveProduct(prod);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));

        return "product-info";
    }
}
