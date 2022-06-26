package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.*;
import pe.edu.pe.bytebackend.service.CustomerService;
import pe.edu.pe.bytebackend.service.EmployeeService;
import pe.edu.pe.bytebackend.service.OrderService;
import pe.edu.pe.bytebackend.service.ShipperService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ShipperService shipperService;

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Order> listOrders(){
        return orderService.listOrders();
    }

    @GetMapping("{id}")
    public Optional<Order> orderById(@PathVariable Integer id){
        return orderService.orderById(id);
    }

    @PostMapping()
    public Order saveOrder(@RequestBody Order order){
        Optional<Employee> employeeOptional = employeeService.employeeById(order.getEmployee().getEmployeeId());
        Optional<Shipper> shipperOptional = shipperService.shipperById(order.getShipper().getShipperId());
        Optional<Customer> customerOptional = customerService.customerById(order.getCustomer().getCustomerId());

        order.setEmployee(employeeOptional.get());
        order.setShipper(shipperOptional.get());
        order.setCustomer(customerOptional.get());
        Order orderSaved = orderService.saveOrder(order);

        return orderSaved;
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Integer id){
        this.orderService.deleteOrder(id);
    }


}
