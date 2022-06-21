package pe.edu.pe.bytebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    private String contactName;
    private String contactTitle;
    private String adress;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homePage;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productList;
}
