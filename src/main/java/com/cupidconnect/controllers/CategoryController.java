package com.cupidconnect.controllers;


import com.cupidconnect.dtos.CategoryDTO;
//import com.cupidconnect.repositories.CategoryRepository;
//import com.cupidconnect.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated
//Dependency Injection
@RequiredArgsConstructor
public class CategoryController {
//    private final CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
            )
    {
        return ResponseEntity.ok("page " + page + " limit: " + limit);
    }

    @PostMapping("")
    public ResponseEntity<?> insertCategory(
            @Valid
            @RequestBody
            CategoryDTO categoryDTO,
            BindingResult result){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("" + categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(){
        return ResponseEntity.ok("update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(){
        return ResponseEntity.ok("delete");
    }
}
