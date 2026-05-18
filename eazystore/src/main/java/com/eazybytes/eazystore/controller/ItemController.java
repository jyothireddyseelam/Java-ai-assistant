package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.ItemDto;
import com.eazybytes.eazystore.entity.Item;
import com.eazybytes.eazystore.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    // Constructor Injection (BEST PRACTICE)
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // CREATE
    @PostMapping
    public Item createItem(@Valid @RequestBody ItemDto itemDto) {
        return itemService.createItem(itemDto);
    }

    // GET ALL
    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item) {
        return itemService.updatedItem(id, item);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        return itemService.deletedItem(id);
    }
}