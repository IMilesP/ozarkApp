package com.isaacp.DBFinal.repository;

import com.isaacp.DBFinal.entity.CafeMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeMenuItemRepository extends JpaRepository<CafeMenuItem, Integer> {
}