package pe.edu.pe.bytebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.bytebackend.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
