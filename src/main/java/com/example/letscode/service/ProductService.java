package com.example.letscode.service;

import com.example.letscode.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();
    private Long id = 0L;

    {
        productList.add(id.intValue(), Product.builder()
                        .id(id++)
                        .title("ps5 title")
                        .author("me")
                        .city("Moscow")
                        .description("new ps5")
                        .price(44000)
                .build());

        productList.add(id.intValue(), Product.builder()
                        .id(id++)
                .title("ps4 title")
                .author("me")
                .city("NN")
                .description("new ps4")
                .price(33000)
                .build());
    }

    public List<Product> list() {
        return productList;
    }

    public void saveProduct(Product product) {
        product.setId(id++);
        productList.add(product);
    }

    public void delete(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        return productList.get(id.intValue());
    }
}
