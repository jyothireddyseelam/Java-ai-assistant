package com.eazybytes.eazystore.service;

import com.eazybytes.eazystore.Exception.ItemNotFoundException;
import com.eazybytes.eazystore.dto.ItemDto;
import com.eazybytes.eazystore.entity.Category;
import com.eazybytes.eazystore.entity.Item;
import com.eazybytes.eazystore.repository.CategoryRepository;
import com.eazybytes.eazystore.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    // Constructor Injection (BEST PRACTICE)

    public ItemService(ItemRepository itemRepository,
                       CategoryRepository categoryRepository) {

        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    // CREATE



    public Item createItem(ItemDto itemDto) {

        Category category = categoryRepository.findById(itemDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Item item = new Item();

        item.setItemName(itemDto.getItemName());
        item.setItemDesc(itemDto.getItemDesc());

        item.setCategory(category);

        return itemRepository.save(item);
    }
    // GET ALL
        public List<Item> getItems() {
            return itemRepository.findAll();
        }

        // GET BY ID
        public Item getItemById(int id) {
            return itemRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));
        }

        // UPDATE
        public Item updatedItem(int id, Item updatedItem) {

            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("Item not found with id: " + id));

            item.setItemName(updatedItem.getItemName());
            item.setItemDesc(updatedItem.getItemDesc());

            return itemRepository.save(item);
        }

        // DELETE
        public String deletedItem(int id) {

            if (itemRepository.existsById(id)) {
                itemRepository.deleteById(id);
                return "Item deleted successfully";
            }

            return "Item not found";
        }
    }
