package pe.edu.pe.bytebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private int employeeId;

    private String lastName;

    private String firstName;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    private String adress;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private String homePhone;

    private String extension;

    private String photo;

    private String notes;

    private String reportsTo;

    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;
}
