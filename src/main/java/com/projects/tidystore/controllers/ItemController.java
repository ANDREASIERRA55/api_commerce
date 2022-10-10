package com.projects.tidystore.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projects.tidystore.entity.Item;
import com.projects.tidystore.services.ItemService;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items")
    public List<Item> getAll() {
        System.out.println(itemService.findAllRooms().toString());
        return itemService.getAll();
    }

    @GetMapping(value = "/items/{id}")
    public Item show(@PathVariable Long id) {
        return itemService.show(id);
    }

    @PostMapping(value = "/items")
    public Item store(@RequestBody Item newItem) {
        Item item = itemService.store(newItem);
        return item;
    }

    @PutMapping(value = "/items/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping(path = "/items/{id}")
    public Map<String, String> deleteItem(@PathVariable Long id) {
        Map<String, String> message = itemService.delete(id);
        return message;
    }
}
