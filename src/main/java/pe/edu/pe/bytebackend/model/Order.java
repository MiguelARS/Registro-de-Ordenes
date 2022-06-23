package pe.edu.pe.bytebackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date requiredDate;

    @Temporal(TemporalType.DATE)
    private Date shippedDate;

    private String shipName;

    private String shipAdress;

    private String shipCity;

    private String shipRegion;

    private String shipPostalCode;

    private String shipCountry;

    /*Muchas ordenes pueden pertenecer a 1 empleado*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Employee employee;

    /*Muchas ordenes pueden pertenecer a 1 transportador*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Shipper shipper;

    /*Muchas ordenes pueden pertenecer a 1 cliente*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
}
