package com.golovanov.productlist.service;

import com.golovanov.productlist.entity.ProductEntity;
import com.golovanov.productlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> list() {
        List<ProductEntity> productEntities = productRepository.findAll();
        if (productEntities.size() > 0) {
            return new ResponseEntity<>(productEntities, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> addNewProduct(ProductEntity productEntity) {
        if (productEntity == null
                || productEntity.getId() == null
                || productEntity.getName() == null
                || productEntity.getDescription() == null
                || productEntity.getKcal() == null) {
            return new ResponseEntity<>("Not all data are provided", HttpStatus.BAD_REQUEST);
        }
        ProductEntity saved = productRepository.save(productEntity);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<?> getProductById(Long id) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
