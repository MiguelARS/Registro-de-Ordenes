package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> categoryById(Integer id){
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
    }
}
