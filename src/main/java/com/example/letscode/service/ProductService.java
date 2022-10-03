package com.example.letscode.service;

import com.example.letscode.models.Product;
import com.example.letscode.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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

    public List<Product> list(String title) {

        if (title != null) {
          return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {

        log.info("save new {}", product);
        productRepository.save(product);

    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no element"));
    }
}
