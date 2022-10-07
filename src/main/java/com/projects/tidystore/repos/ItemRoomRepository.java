package com.projects.tidystore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.tidystore.entity.Room;

@Repository
public interface ItemRoomRepository extends JpaRepository<Room, Long> {

}
