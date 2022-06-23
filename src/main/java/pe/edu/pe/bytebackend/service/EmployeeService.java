package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Employee;
import pe.edu.pe.bytebackend.model.Supplier;
import pe.edu.pe.bytebackend.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> listEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> employeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }
}
