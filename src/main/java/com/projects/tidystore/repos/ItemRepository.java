package com.projects.tidystore.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projects.tidystore.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT i.room FROM Item i GROUP BY i.room")
    List<String> getRooms();

    @Query(value = "SELECT i.shelving FROM Item i GROUP BY i.shelving")
    List<String> getShelvings();

    @Query(value = "SELECT i.section FROM Item i GROUP BY i.section")
    List<String> getSections();

    @Query(value = "SELECT i.position FROM Item i GROUP BY i.position")
    List<String> getPositions();

    @Query(value = "SELECT i.box FROM Item i GROUP BY i.box")
    List<String> getBoxes();

    @Query("SELECT i FROM Item i WHERE i.name LIKE CONCAT ('%',:n,'%')")
    public List<Item> getItemByNameJPQL(@Param("n") String name);

}
