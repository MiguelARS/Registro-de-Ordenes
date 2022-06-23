package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Order;
import pe.edu.pe.bytebackend.model.Product;
import pe.edu.pe.bytebackend.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> listOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> orderById(Integer id){
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
}
