package com.projects.tidystore.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.projects.tidystore.entity.RoomGroup;

public interface RoomRepository {
    @Query(value = "SELECT room, COUNT(*) as total FROM items GROUP BY room", nativeQuery = true)
    List<RoomGroup> findRoomItems();
}
