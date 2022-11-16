package com.golovanov.productlist.service;

import com.golovanov.productlist.entity.ListEntity;
import com.golovanov.productlist.entity.ProductEntity;
import com.golovanov.productlist.repository.ListRepository;
import com.golovanov.productlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> addProductToList(Long listId, Long productId) {
        Optional<ListEntity> listOptional = listRepository.findById(listId);
        Optional<ProductEntity> productOptional = productRepository.findById(productId);
        if (listOptional.isEmpty() || productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ListEntity list = listOptional.get();
        ProductEntity product = productOptional.get();

        list.getProducts().add(product);

        return new ResponseEntity<>(listRepository.save(list), HttpStatus.OK);
    }
}
