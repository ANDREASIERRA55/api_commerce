package com.projects.tidystore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.tidystore.dtos.ItemDto;
import com.projects.tidystore.entity.Item;
import com.projects.tidystore.entity.Room;
import com.projects.tidystore.repos.ItemRepository;
import com.projects.tidystore.repos.ItemRoomRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemRoomRepository itemRoomRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item store(ItemDto newItem) {
        Item item = new Item();
        item.setShelving(newItem.getShelving());
        item.setSection(newItem.getSection());
        item.setPosition(newItem.getPosition());
        item.setBox(newItem.getBox());
        item.setName(newItem.getName());
        Room room = itemRoomRepository.findById(newItem.getRoomId()).orElse(null);
        item.setRoom(room);
        return itemRepository.save(item);
    }

}
