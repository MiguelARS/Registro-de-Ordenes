package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Product;
import pe.edu.pe.bytebackend.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> productById(Integer id){
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
