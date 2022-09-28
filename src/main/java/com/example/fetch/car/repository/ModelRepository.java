package com.example.fetch.car.repository;

import com.example.fetch.car.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {

    @Query(value = "select m from Model m where m.brand.id = :brandId ")
    List<Model> getModelByBrandId(@Param("brandId") int brandId);

    @Query(value = "select m from Model m where m.name like lower(concat('%',:keyword,'%'))")
    List<Model> searchCarByKeyword(@Param("keyword") String keyword);

}
