package com.isaacp.DBFinal.service;

import com.isaacp.DBFinal.entity.CafeMenuItem;
import com.isaacp.DBFinal.exception.CafeMenuItemNotFoundException;
import com.isaacp.DBFinal.repository.CafeMenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeMenuItemRepository cafeMenuItemRepository;

    public void addMenuItem(String itemName, String itemDescription) {
        CafeMenuItem item = new CafeMenuItem();

        item.setItemName(itemName);
        item.setItemDescription(itemDescription);

        cafeMenuItemRepository.save(item);
    }

    public void deleteMenuItem(int itemId) throws CafeMenuItemNotFoundException {
        cafeMenuItemRepository.delete(getMenuItem(itemId));
    }

    private CafeMenuItem getMenuItem(int itemId) throws CafeMenuItemNotFoundException {
        return cafeMenuItemRepository.findById(itemId)
                .orElseThrow(() -> new CafeMenuItemNotFoundException(String.format("Cafe menu item with id %d could not be found", itemId)));
    }

    public List<CafeMenuItem> listMenuItems() {
        return cafeMenuItemRepository.findAll();
    }
}
