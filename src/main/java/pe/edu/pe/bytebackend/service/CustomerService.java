package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Customer;
import pe.edu.pe.bytebackend.model.Shipper;
import pe.edu.pe.bytebackend.repository.CustomerRepository;
import pe.edu.pe.bytebackend.repository.ShipperRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> customerById(Integer id){
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }
}
