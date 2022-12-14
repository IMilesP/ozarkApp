package com.isaacp.DBFinal.controller;

import com.isaacp.DBFinal.entity.CafeMenuItem;
import com.isaacp.DBFinal.exception.CafeMenuItemNotFoundException;
import com.isaacp.DBFinal.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/cafe")
public class CafeController {
    @Autowired
    private CafeService cafeService;

    @PostMapping("/add-item")
    public ResponseEntity<Object> addCafeMenuItem(@RequestParam String itemName,
                                                  @RequestParam String itemDescription) {
        cafeService.addMenuItem(itemName, itemDescription);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/delete-item/{itemId}")
    public ResponseEntity<Object> deleteCafeMenuItem(@PathVariable int itemId) throws CafeMenuItemNotFoundException {
        cafeService.deleteMenuItem(itemId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/list-items")
    public ResponseEntity<List<CafeMenuItem>> listCafeMenuItems() {
        return ResponseEntity.ok(cafeService.listMenuItems());
    }

    //add endpoint(s) to edit weekly menu
}
