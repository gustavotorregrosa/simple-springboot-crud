package com.gustavotorregrosa.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavotorregrosa.simplecrud.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
