package com.isaacp.DBFinal.repository;

import com.isaacp.DBFinal.entity.DormLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DormLeaveRepository extends JpaRepository<DormLeave, Integer> {
    @Query("select dormLeave " +
            "from DormLeave dormLeave " +
            "where dormLeave.approvalStatus = 'pending'")
    List<DormLeave> getAllActiveLeaves();
}