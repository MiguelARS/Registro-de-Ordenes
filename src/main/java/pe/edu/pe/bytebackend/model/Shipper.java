package pe.edu.pe.bytebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue
    private int shipperId;

    private String companyName;
    private String phone;

    @OneToMany(mappedBy = "shipper")
    private List<Order> orderList;
}
