package com.mphasis.springboot.model.services;

import com.mphasis.springboot.model.entities.Product;
import com.mphasis.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service   //This class is now a bean.
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id){
       Optional<Product> productFromTable = productRepository.findById(id);
       if(productFromTable.isPresent()){
           return productFromTable.get();
       }
       else{
           throw new ResourceNotFoundException("Produce not found with ID: " + id);
       }
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productFromTable = productRepository.findById(product.getId());
        if(productFromTable.isPresent()){
            Product productToUpdate =  productFromTable.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setQuantity(product.getQuantity());
            productRepository.save(productToUpdate);
            return productToUpdate;
        }
        else{
            throw new ResourceNotFoundException("Produce not found !!!");
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Optional<Product> productFromTable = productRepository.findById(id);
        if(productFromTable.isPresent()){
            Product productToDelete = productFromTable.get();
            productRepository.delete(productToDelete);
            return true;
        }
        else{
            throw new ResourceNotFoundException("Produce not found !!!");
        }
    }
}
