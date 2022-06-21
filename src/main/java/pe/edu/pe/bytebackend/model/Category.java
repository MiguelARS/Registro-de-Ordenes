package pe.edu.pe.bytebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Data
@Entity
@Table(name = "catogories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    private String categoryName;

    private String description;

    private String picture;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
