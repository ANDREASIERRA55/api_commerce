package com.projects.tidystore.repos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projects.tidystore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select s.id, s.room from items s")

    Collection<Item> findAllRooms();
}
