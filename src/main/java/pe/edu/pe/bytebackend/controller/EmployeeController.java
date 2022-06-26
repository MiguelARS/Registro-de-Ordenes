package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.Employee;
import pe.edu.pe.bytebackend.model.Supplier;
import pe.edu.pe.bytebackend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> listEmployee(){
        return employeeService.listEmployee();
    }

    @GetMapping("{id}")
    public Optional<Employee> employeeById(@PathVariable Integer id){
        return employeeService.employeeById(id);
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Integer id){
        this.employeeService.deleteEmployee(id);
    }

}
