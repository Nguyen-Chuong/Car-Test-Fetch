package com.example.fetch.car.service;

import com.example.fetch.car.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    void addBrand(String name, String logo);

    List<BrandDTO> getAllBrands();

    void updateBrand(BrandDTO brandDTO);

    void deleteBrand(int brandId);

}
