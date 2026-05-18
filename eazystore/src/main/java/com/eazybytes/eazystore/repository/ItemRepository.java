package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
