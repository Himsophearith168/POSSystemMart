package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Integer> {
}
