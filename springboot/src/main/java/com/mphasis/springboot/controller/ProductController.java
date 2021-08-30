package com.mphasis.springboot.controller;

import com.mphasis.springboot.model.entities.Product;
import com.mphasis.springboot.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ProductController {

    @Autowired  //Injection
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")  //id is a named parameter
    public ResponseEntity<Product> getProductById(@PathVariable int id){  //names should be same of id
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product){
        product.setId(id);
        return ResponseEntity.ok().body(productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
