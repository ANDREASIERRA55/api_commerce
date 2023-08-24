package com.projects.tidystore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.tidystore.entity.Item;
import com.projects.tidystore.repos.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item show(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item store(Item newItem) {
        Item item = new Item();
        item.setShelving(newItem.getShelving());
        item.setSection(newItem.getSection());
        item.setPosition(newItem.getPosition());
        item.setBox(newItem.getBox());
        item.setName(newItem.getName());
        item.setRoom(newItem.getRoom());
        return itemRepository.save(item);
    }

    public Item update(Long id, Item modifiedItem) {

        return itemRepository.findById(id)
                .map((item) -> {
                    item.setShelving(modifiedItem.getShelving());
                    item.setSection(modifiedItem.getSection());
                    item.setPosition(modifiedItem.getPosition());
                    item.setBox(modifiedItem.getBox());
                    item.setName(modifiedItem.getName());
                    item.setRoom(modifiedItem.getRoom());
                    return itemRepository.save(item);
                })
                .orElseGet(() -> {
                    return itemRepository.save(modifiedItem);
                });
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

    public List<Item> getItemsbyNameJPQL(String name) {
        return itemRepository.getItemByNameJPQL(name);
    }
}
