package com.example.fetch.car.repository;

import com.example.fetch.car.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
