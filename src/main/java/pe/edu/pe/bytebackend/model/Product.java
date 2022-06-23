package pe.edu.pe.bytebackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int productId;

    private String productName;

    private Integer quantity;

    private Integer unitPrice;

    private Integer unitStock;

    private Integer unitOrder;

    private Integer reorderLevel;

    private Boolean discontinued;

    /*Muchos productos pertenecerán a 1 categoría*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    /*Muchos productos pertenecerán a 1 proveedor*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList;

}
