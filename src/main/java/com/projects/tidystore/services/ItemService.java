package com.projects.tidystore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.tidystore.daos.BoxDao;
import com.projects.tidystore.daos.PositionDao;
import com.projects.tidystore.daos.RoomDao;
import com.projects.tidystore.daos.SectionDao;
import com.projects.tidystore.daos.ShelvingDao;
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

    public List<RoomDao> findRooms() {
        List<String> roomList = itemRepository.getRooms();
        List<RoomDao> rooms = new ArrayList<>();

        for (String name : roomList) {
            RoomDao roomDao = RoomDao.builder().name(name).build();
            rooms.add(roomDao);
        }
        return rooms;
    }

    public List<ShelvingDao> findShelvings() {
        List<String> shelvingList = itemRepository.getShelvings();
        List<ShelvingDao> shelvings = new ArrayList<>();

        for (String name : shelvingList) {
            ShelvingDao shelvingDao = ShelvingDao.builder().name(name).build();
            shelvings.add(shelvingDao);
        }
        return shelvings;
    }

    public List<SectionDao> findSections() {
        List<String> sectionList = itemRepository.getSections();
        List<SectionDao> sections = new ArrayList<>();

        for (String name : sectionList) {
            SectionDao sectionDao = SectionDao.builder().name(name).build();
            sections.add(sectionDao);
        }
        return sections;
    }

    public List<PositionDao> findPositions() {
        List<String> positionList = itemRepository.getPositions();
        List<PositionDao> positions = new ArrayList<>();

        for (String name : positionList) {
            PositionDao positionDao = PositionDao.builder().name(name).build();
            positions.add(positionDao);
        }
        return positions;
    }

    public List<BoxDao> findBoxes() {
        List<String> boxList = itemRepository.getBoxes();
        List<BoxDao> boxes = new ArrayList<>();

        for (String name : boxList) {
            BoxDao boxDao = BoxDao.builder().name(name).build();
            boxes.add(boxDao);
        }
        return boxes;
    }

    public List<Item> getItemsbyNameJPQL(String name) {
        return itemRepository.getItemByNameJPQL(name);
    }
}
