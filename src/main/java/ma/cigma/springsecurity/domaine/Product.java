package ma.cigma.springsecurity.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String ProductName;
    private String Category;
    private String Quantity;
    private String ModelNumber;
    private String AboutProduct;
    private String TechnicalDetails;
    private String ShippingWeight;
    private String Image;

}
