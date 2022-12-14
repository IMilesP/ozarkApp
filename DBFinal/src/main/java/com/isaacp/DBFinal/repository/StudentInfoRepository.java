package com.isaacp.DBFinal.repository;

import com.isaacp.DBFinal.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo, Integer> {
}