package com.example.fetch.car.service.serviceImpl;

import com.example.fetch.car.dto.ModelDTO;
import com.example.fetch.car.entity.Brand;
import com.example.fetch.car.entity.Model;
import com.example.fetch.car.repository.ModelRepository;
import com.example.fetch.car.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCarModel(String name, String description, int brandId) {
        Model model = new Model();
        model.setName(name);
        model.setDescription(description);
        Brand brand = new Brand();
        brand.setId(brandId);
        model.setBrand(brand);
        modelRepository.save(model);
    }

    @Override
    public List<ModelDTO> getAllCarModel() {
        List<Model> modelList = modelRepository.findAll();
        return modelList.stream().map(item -> modelMapper.map(item, ModelDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void updateCarModel(ModelDTO modelDTO) {
        Model model = modelRepository.getById(modelDTO.getId());
        model.setName(modelDTO.getName());
        model.setDescription(modelDTO.getDescription());
        modelRepository.save(model);
    }

    @Override
    public void deleteCarModel(int modelId) {
        modelRepository.deleteById(modelId);
    }

    @Override
    public List<ModelDTO> fetchAllCarByBrandName(int brandId) {
        List<Model> modelList = modelRepository.getModelByBrandId(brandId);
        return modelList.stream().map(item -> modelMapper.map(item, ModelDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ModelDTO> searchCarByKeyword(String keyword) {
        List<Model> modelList = modelRepository.searchCarByKeyword(keyword);
        return modelList.stream().map(item -> modelMapper.map(item, ModelDTO.class)).collect(Collectors.toList());
    }
}
