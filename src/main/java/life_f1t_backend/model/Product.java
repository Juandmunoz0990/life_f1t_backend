package life_f1t_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String name;

    @NotBlank(message = "La marca es obligatoria")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String brand;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String category; // luego lo hacemos enum o tabla Category

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(nullable = false)
    private Integer stock;

    @Size(max = 500)
    @Column(length = 500)
    private String description;

    @Size(max = 300)
    @Column(length = 300)
    private String imageUrl;
}
