package io.github.BrenoHen.produtosApi.controller;

import io.github.BrenoHen.produtosApi.model.Product;
import io.github.BrenoHen.produtosApi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class productController {

    private ProductRepository productRepository;

    public productController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        System.out.println("Product received: " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateProduct(@PathVariable("id") String id,
                              @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> searchProduct(@RequestParam("name") String name){
        return productRepository.findByName(name);
    }
}
