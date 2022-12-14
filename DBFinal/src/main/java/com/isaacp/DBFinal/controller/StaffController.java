package com.isaacp.DBFinal.controller;

import com.isaacp.DBFinal.entity.StaffAccount;
import com.isaacp.DBFinal.entity.StaffInfo;
import com.isaacp.DBFinal.exception.AccountNotFoundException;
import com.isaacp.DBFinal.exception.InfoNotFoundException;
import com.isaacp.DBFinal.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    public ResponseEntity<Object> addStaff(@RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String email) {
        staffService.addStaff(firstName, lastName, email);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<StaffInfo> getStaff(@PathVariable int staffId) throws InfoNotFoundException {
        return ResponseEntity.ok(staffService.getStaff(staffId));
    }

    @PostMapping("/account/add")
    public ResponseEntity<Object> addStaffAccount(@RequestParam int staffId,
                                                    @RequestParam String username,
                                                    @RequestParam String password) throws InfoNotFoundException {
        staffService.addAccount(staffId, username, password);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<StaffAccount> getStaffAccount(@PathVariable int accountId) throws AccountNotFoundException {
        return ResponseEntity.ok(staffService.getAccount(accountId));
    }
}
