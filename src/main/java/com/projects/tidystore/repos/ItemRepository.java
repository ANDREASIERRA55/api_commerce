package com.projects.tidystore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.tidystore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
