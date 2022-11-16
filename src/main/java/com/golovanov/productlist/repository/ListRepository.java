package com.golovanov.productlist.repository;

import com.golovanov.productlist.entity.ListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends MongoRepository<ListEntity, Long> {
}
