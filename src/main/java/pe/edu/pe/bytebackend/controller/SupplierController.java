package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Category;
import pe.edu.pe.bytebackend.model.Supplier;
import pe.edu.pe.bytebackend.service.CategoryService;
import pe.edu.pe.bytebackend.service.SupplierService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public List< Supplier> listSupplier(){
        return supplierService.listSupplier();
    }

    @GetMapping("{id}")
    public Optional<Supplier> supplierById(@PathVariable Integer id){
        return supplierService.supplierById(id);
    }

    @PostMapping()
    public Supplier saveSupplier(@RequestBody Supplier supplier){

        return supplierService.saveSupplier(supplier);
    }

    @PutMapping("{id}")
    public void deleteSupplier(@PathVariable Integer id){
        this.supplierService.deleteSupplier(id);
    }

}
