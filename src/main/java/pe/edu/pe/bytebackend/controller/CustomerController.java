package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Customer;
import pe.edu.pe.bytebackend.model.Shipper;
import pe.edu.pe.bytebackend.service.CustomerService;
import pe.edu.pe.bytebackend.service.ShipperService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> listCustomer(){
        return customerService.listCustomer();
    }

    @GetMapping("{id}")
    public Optional<Customer> customerById(@PathVariable Integer id){
        return customerService.customerById(id);
    }

    @PostMapping()
    public Customer saveCustomer(@RequestBody Customer customer){

        return customerService.saveCustomer(customer);
    }

    @PutMapping("{id}")
    public void deleteCustomer(@PathVariable Integer id){
        this.customerService.deleteCustomer(id);
    }
}
