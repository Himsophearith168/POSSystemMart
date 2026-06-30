package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository  extends JpaRepository<BrandModel,Long> {
}
