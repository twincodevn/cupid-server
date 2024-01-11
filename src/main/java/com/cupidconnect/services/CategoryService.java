//package com.cupidconnect.services;
//
//import com.cupidconnect.dtos.CategoryDTO;
//import com.cupidconnect.models.Category;
//import com.cupidconnect.repositories.CategoryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CategoryService implements ICategoryService{
//    private final CategoryRepository categoryRepository;
//
//    @Override
//    public Category createCategory(CategoryDTO categoryDTO) {
//        Category newCategory = Category.builder().name(categoryDTO.getName()).build();
//        return categoryRepository.save(newCategory);
//    }
//
//    @Override
//    public Category getCategoryById(long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//}
