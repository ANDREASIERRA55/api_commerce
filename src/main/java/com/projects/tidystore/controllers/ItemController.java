package com.projects.tidystore.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.tidystore.dtos.ItemDto;
import com.projects.tidystore.entity.Item;
import com.projects.tidystore.services.ItemService;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/items")
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @PostMapping(value = "/items")
    public Item store(@RequestBody ItemDto newItem) {
        Item item = itemService.store(newItem);
        return item;
    }

    @PutMapping(path = "/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {

        return itemService.update(id, item);
    }

    @DeleteMapping(path = "/items/{id}")
    public Map<String, String> deleteItem(@PathVariable Long id) {
        Map<String, String> message = itemService.delete(id);
        return message;
    }

}
