package com.golovanov.productlist.controller;

import com.golovanov.productlist.service.AssignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assign")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://http://localhost:8383")
@Api("Controller for adding product to list")
public class AssignController {

    private final AssignService assignService;

    @PostMapping("/")
    @ApiOperation("Add product to list")
    public ResponseEntity<?> addProductToList(Long listId, Long productId) {
        try {
            return new ResponseEntity<>(assignService.addProductToList(listId, productId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    @ApiOperation("remove product from list - not implemented yet")
    public ResponseEntity<?> removeProductFromList(Long listId, Long productId) {
        return new ResponseEntity<>("Not implemented", HttpStatus.OK);
    }

}
