package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hybernateLazyInitialzer","handler","products"})
public class Category {

    @Column(name = "category_id")
    @Id
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
