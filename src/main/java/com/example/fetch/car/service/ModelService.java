package com.example.fetch.car.service;

import com.example.fetch.car.dto.ModelDTO;

import java.util.List;

public interface ModelService {

    void addCarModel(String name, String description, int brandId);

    List<ModelDTO> getAllCarModel();

    void updateCarModel(ModelDTO modelDTO);

    void deleteCarModel(int modelId);

    List<ModelDTO> fetchAllCarByBrandName(int brandId);

    List<ModelDTO> searchCarByKeyword(String keyword);

}
