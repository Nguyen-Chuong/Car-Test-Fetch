package com.example.fetch.car.resource;

import com.example.fetch.car.dto.ModelDTO;
import com.example.fetch.car.service.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModelResource {

    private final ModelService modelService;

    public ModelResource(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/add-model")
    private ResponseEntity<?> addModel(@RequestParam String name, @RequestParam String description, @RequestParam int brandId){
        try{
            modelService.addCarModel(name, description, brandId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-model")
    private ResponseEntity<?> getAllModel(){
        try{
            List<ModelDTO> modelDTOList = modelService.getAllCarModel();
            return new ResponseEntity<>(modelDTOList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update-model")
    private ResponseEntity<?> updateModel(@RequestBody ModelDTO modelDTO){
        try{
            modelService.updateCarModel(modelDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-model/{id}")
    private ResponseEntity<?> deleteModel(@PathVariable int id){
        try{
            modelService.deleteCarModel(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/fetch-by-brand")
    private ResponseEntity<?> fetchByBrand(@RequestParam int brandId){
        try{
            List<ModelDTO> modelDTOList = modelService.fetchAllCarByBrandName(brandId);
            return new ResponseEntity<>(modelDTOList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search-model")
    private ResponseEntity<?> searchByKeyword(@RequestParam String text){
        try{
            List<ModelDTO> modelDTOList = modelService.searchCarByKeyword(text);
            return new ResponseEntity<>(modelDTOList, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
