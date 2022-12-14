package com.isaacp.DBFinal.repository;

import com.isaacp.DBFinal.entity.StudentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAccountRepository extends JpaRepository<StudentAccount, Integer> {
}