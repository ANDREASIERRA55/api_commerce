package com.projects.tidystore.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projects.tidystore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // @Query("SELECT p from items p WHERE CONCAT(p.name, ' ', p.room, ' ',
    // p.section, ' ', p.shelving, ' ', p.position, ' ', p.box, ' ') LIKE
    // CONCAT('%',:keyword,'%')")
    // List<Item> searchItems(String keyword);
}
