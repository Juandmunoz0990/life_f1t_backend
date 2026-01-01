package life_f1t_backend.mapper;

import life_f1t_backend.dto.ProductRequestDTO;
import life_f1t_backend.dto.ProductResponseDTO;
import life_f1t_backend.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setBrand(dto.getBrand());
        p.setCategory(dto.getCategory());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());
        p.setDescription(dto.getDescription());
        p.setImageUrl(dto.getImageUrl());
        return p;
    }

    public static ProductResponseDTO toResponse(Product p) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setBrand(p.getBrand());
        dto.setCategory(p.getCategory());
        dto.setPrice(p.getPrice());
        dto.setStock(p.getStock());
        dto.setDescription(p.getDescription());
        dto.setImageUrl(p.getImageUrl());
        return dto;
    }
}