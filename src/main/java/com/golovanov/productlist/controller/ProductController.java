package com.golovanov.productlist.controller;

import com.golovanov.productlist.entity.ProductEntity;
import com.golovanov.productlist.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://http://localhost:8383")
@Api("Controller for adding products and gettind list of all products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    @ApiOperation("Getting list of all products")
    public ResponseEntity<?> getAllProducts() {
        try {
            return productService.list();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation("Adding new product")
    public ResponseEntity<?> addNewProduct(ProductEntity product) {
        try {
            return productService.addNewProduct(product);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Get product by id")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        try {
            return productService.getProductById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("update of product - not implemented")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, ProductEntity product) {
        return new ResponseEntity<>("Not implemented", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete product by id - not implemented")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        return new ResponseEntity<>("Not implemented", HttpStatus.OK);
    }
}
