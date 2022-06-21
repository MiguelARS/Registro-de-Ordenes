package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Supplier;
import pe.edu.pe.bytebackend.repository.CategoryRepository;
import pe.edu.pe.bytebackend.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> listSupplier(){
        return supplierRepository.findAll();
    }

    public Optional<Supplier> supplierById(Integer id){
        return supplierRepository.findById(id);
    }

    public Supplier saveSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
    }
}
