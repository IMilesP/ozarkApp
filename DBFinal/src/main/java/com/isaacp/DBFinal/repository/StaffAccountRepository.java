package com.isaacp.DBFinal.repository;

import com.isaacp.DBFinal.entity.StaffAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffAccountRepository extends JpaRepository<StaffAccount, Integer> {
}