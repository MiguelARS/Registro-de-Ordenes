package pe.edu.pe.bytebackend.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Product;
import pe.edu.pe.bytebackend.model.Supplier;
import pe.edu.pe.bytebackend.service.CategoryService;
import pe.edu.pe.bytebackend.service.ProductService;
import pe.edu.pe.bytebackend.service.SupplierService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("{id}")
    public Optional<Product> productById(@PathVariable Integer id){
        return productService.productById(id);
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product){
        Optional<Category> categoryOptional = categoryService.categoryById(product.getCategory().getCategoryId());
        Optional<Supplier> supplierOptional = supplierService.supplierById(product.getSupplier().getSupplierId());

        product.setCategory(categoryOptional.get());
        product.setSupplier(supplierOptional.get());
        Product productSaved = productService.saveProduct(product);

        return productSaved;
    }

    @PutMapping("{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
    }


}
