package pe.edu.pe.bytebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;

    private String companyName;

    private String contactName;

    private String contactTitle;

    private String address;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private String phone;

    private String fax;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;
}
