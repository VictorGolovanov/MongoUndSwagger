package com.golovanov.productlist.controller;

import com.golovanov.productlist.entity.ListEntity;
import com.golovanov.productlist.service.ListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://http://localhost:8383")
@Api("Controller for getting list of all lists and adding a new one")
public class ListController {

    private final ListService listService;

    @GetMapping("/")
    @ApiOperation("get all lists")
    public ResponseEntity<?> getAllLists() {
        try {
            return listService.list();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @ApiOperation("add new list")
    public ResponseEntity<?> addNewList(ListEntity list) {
        try {
            return listService.addNewList(list);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("get list by id")
    public ResponseEntity<?> getListById(@PathVariable Long id) {
        try {
            return listService.getListById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("update of list - not implemented")
    public ResponseEntity<?> updateList(@PathVariable Long id, ListEntity list) {
        return new ResponseEntity<>("Not implemented", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete list by id - not implemented")
    public ResponseEntity<?> deleteListtById(@PathVariable Long id) {
        return new ResponseEntity<>("Not implemented", HttpStatus.OK);
    }
}
