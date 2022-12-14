package com.isaacp.DBFinal.service;

import com.isaacp.DBFinal.entity.StaffAccount;
import com.isaacp.DBFinal.entity.StaffInfo;
import com.isaacp.DBFinal.exception.AccountNotFoundException;
import com.isaacp.DBFinal.exception.InfoNotFoundException;
import com.isaacp.DBFinal.repository.StaffAccountRepository;
import com.isaacp.DBFinal.repository.StaffInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffInfoRepository staffInfoRepository;

    private final StaffAccountRepository staffAccountRepository;

    public void addStaff(String firstName, String lastName, String email) {
        StaffInfo staff = new StaffInfo();

        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setEmail(email);
        staff.setStaffStatus("active");

        staffInfoRepository.save(staff);
    }

    public StaffInfo getStaff(int staffId) throws InfoNotFoundException {
        return staffInfoRepository.findById(staffId)
                .orElseThrow(() -> new InfoNotFoundException(String.format("Staff with id %s could not be found", staffId)));
    }

    public void addAccount(int staffId, String username, String password) throws InfoNotFoundException {
        StaffAccount account = new StaffAccount();

        //account.setStaffInfo(getStaff(staffId)); fix session/persistence
        account.setUsername(username);
        account.setPassword(password);
        account.setAccountStatus("active");

        staffAccountRepository.save(account);
    }

    public StaffAccount getAccount(int accountId) throws AccountNotFoundException {
        return staffAccountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(String.format("Staff account with id %s could not be found", accountId)));
    }
}
