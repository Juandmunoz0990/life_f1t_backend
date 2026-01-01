package life_f1t_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter

public class ProductResponseDTO {

    private Long id;
    private String name;
    private String brand;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String imageUrl;

}