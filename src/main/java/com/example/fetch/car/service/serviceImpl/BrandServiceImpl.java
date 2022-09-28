package com.example.fetch.car.service.serviceImpl;

import com.example.fetch.car.dto.BrandDTO;
import com.example.fetch.car.entity.Brand;
import com.example.fetch.car.repository.BrandRepository;
import com.example.fetch.car.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBrand(String name, String logo) {
        Brand brand = new Brand();
        brand.setLogo(logo);
        brand.setName(name);
        brandRepository.save(brand);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brandList = brandRepository.findAll();
        return brandList.stream().map(item -> modelMapper.map(item, BrandDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void updateBrand(BrandDTO brandDTO) {
        Brand brand = brandRepository.getById(brandDTO.getId());
        brand.setName(brandDTO.getName());
        brand.setLogo(brandDTO.getLogo());
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(int brandId) {
        brandRepository.deleteById(brandId);
    }
}
