package pe.edu.pe.bytebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bytebackend.model.*;
import pe.edu.pe.bytebackend.service.OrderDetailService;
import pe.edu.pe.bytebackend.service.OrderService;
import pe.edu.pe.bytebackend.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<OrderDetail> listOrderDetail(){
        return orderDetailService.listOrderDetail();
    }

    @PostMapping()
    public OrderDetail saveOrderDetail(@RequestBody OrderDetail orderdetail){
        Optional<Order> orderOptional = orderService.orderById(orderdetail.getOrder().getOrderId());
        Optional<Product> productOptional = productService.productById(orderdetail.getProduct().getProductId());

        orderdetail.setOrder(orderOptional.get());
        orderdetail.setProduct(productOptional.get());
        OrderDetail orderDetailSaved = orderDetailService.saveOrderDetail(orderdetail);

        return orderDetailSaved;
    }

    @PutMapping("{id}")
    public void deleteOrderDetail(@PathVariable Integer id){
        this.orderDetailService.deleteOrderDetail(id);
    }

}
