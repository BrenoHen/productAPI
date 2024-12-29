package io.github.BrenoHen.produtosApi.repository;

import io.github.BrenoHen.produtosApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, String>{

    List<Product> findByName(String name);
}