package com.example.fetch.car.resource;

import com.example.fetch.car.dto.BrandDTO;
import com.example.fetch.car.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandResource {

    private final BrandService brandService;

    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/add-brand")
    private ResponseEntity<?> addBrand(@RequestParam String name, @RequestParam String logo){
        try{
            brandService.addBrand(name, logo);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-brand")
    private ResponseEntity<?> getAllBrand(){
        try{
            List<BrandDTO> brandDTOList = brandService.getAllBrands();
            return new ResponseEntity<>(brandDTOList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update-brand")
    private ResponseEntity<?> updateBrand(@RequestBody BrandDTO brandDTO){
        try{
            brandService.updateBrand(brandDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-brand/{id}")
    private ResponseEntity<?> deleteBrand(@PathVariable int id){
        try{
            brandService.deleteBrand(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
