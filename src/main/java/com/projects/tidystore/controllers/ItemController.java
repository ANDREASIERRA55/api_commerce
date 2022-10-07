package com.projects.tidystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        // System.out.println(newItem.getName());
        Item item = itemService.store(newItem);
        return item;
    }
}
