package com.mphasis.springboot.repositories;

import com.mphasis.springboot.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
            //all database commands are in jpa repo, so you don't have to code anything.
}
