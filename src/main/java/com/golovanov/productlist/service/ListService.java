package com.golovanov.productlist.service;

import com.golovanov.productlist.dto.ListDTO;
import com.golovanov.productlist.entity.ListEntity;
import com.golovanov.productlist.repository.ListRepository;
import com.golovanov.productlist.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public ResponseEntity<?> list() {
        List<ListEntity> listEntities = listRepository.findAll();
        if (listEntities.size() > 0) {
            List<ListDTO> dtoList = new ArrayList<>();
            listEntities.forEach(list -> dtoList.add(MappingUtils.mapToListDTO(list)));
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> addNewList(ListEntity listEntity) {
        ListEntity saved = listRepository.save(listEntity);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<?> getListById(Long id) {
        Optional<ListEntity> listOptional = listRepository.findById(id);
        if (listOptional.isPresent()) {
            return new ResponseEntity<>(listOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
