package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Product;
import pe.edu.pe.bytebackend.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> listCategories(){
        return categoryService.listCategories();
    }

    @GetMapping("{id}")
    public Optional<Category> categoryById(@PathVariable Integer id){
        return categoryService.categoryById(id);
    }

    @PostMapping()
    public Category saveCategory(@RequestBody Category category){

        return categoryService.saveCategory(category);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Integer id){
        this.categoryService.deleteCategory(id);
    }

}
