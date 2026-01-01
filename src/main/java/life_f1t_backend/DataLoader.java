package life_f1t_backend;

import life_f1t_backend.model.Product;
import life_f1t_backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductRepository repository) {
        return args -> {

            if (repository.count() == 0) {

                Product p1 = Product.builder()
                        .name("Whey Protein")
                        .brand("Optimum Nutrition")
                        .category("Proteina")
                        .price(new BigDecimal("189900"))
                        .stock(10)
                        .description("Proteína para recuperación muscular")
                        .build();

                Product p2 = Product.builder()
                        .name("Creatina Monohidratada")
                        .brand("Universal")
                        .category("Creatina")
                        .price(new BigDecimal("79900"))
                        .stock(20)
                        .description("Mejora fuerza y rendimiento")
                        .build();

                repository.save(p1);
                repository.save(p2);
            }
        };
    }
}
