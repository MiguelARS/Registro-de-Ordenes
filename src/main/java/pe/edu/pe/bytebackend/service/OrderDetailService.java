package pe.edu.pe.bytebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bytebackend.model.Order;
import pe.edu.pe.bytebackend.model.OrderDetail;
import pe.edu.pe.bytebackend.repository.OrderDetailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> listOrderDetail(){
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> orderDetailById(Integer id){
        return orderDetailRepository.findById(id);
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(Integer id){
        orderDetailRepository.deleteById(id);
    }
}
