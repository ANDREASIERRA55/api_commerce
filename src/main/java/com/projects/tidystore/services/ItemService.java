package com.projects.tidystore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Map<String, String> delete(Long id) {
        Map<String, String> message = new HashMap<>();
        if (itemRepository.findById(id).isPresent()) {
            itemRepository.deleteById(id);
            message.put("message", "OK");
            return message;
        }
        message.put("message", "Error");
        return message;
    }

    public Item update(Long id, Item newDataItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newDataItem.getName());
                    item.setShelving(newDataItem.getShelving());
                    item.setSection(newDataItem.getSection());
                    item.setPosition(newDataItem.getPosition());
                    item.setBox(newDataItem.getBox());
                    item.setRoom(newDataItem.getRoom());
                    return itemRepository.save(newDataItem);
                }).orElseGet(() -> {
                    newDataItem.setId(id);
                    return itemRepository.save(newDataItem);
                });
    }
}
