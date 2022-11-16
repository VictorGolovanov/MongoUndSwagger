package com.golovanov.productlist.utils;

import com.golovanov.productlist.dto.ListDTO;
import com.golovanov.productlist.entity.ListEntity;
import com.golovanov.productlist.entity.ProductEntity;

public class MappingUtils {

    public static ListDTO mapToListDTO(ListEntity listEntity) {
        ListDTO listDTO = new ListDTO();

        listDTO.setId(listEntity.getId());
        listDTO.setName(listEntity.getName());
        listDTO.setProducts(listEntity.getProducts());
        listDTO.setTotalKcal(listEntity.getProducts().stream().mapToInt(ProductEntity::getKcal).sum());

        return listDTO;
    }
}
