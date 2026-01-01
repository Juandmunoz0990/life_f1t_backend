package life_f1t_backend.service;

import life_f1t_backend.model.Product;
import life_f1t_backend.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Page<Product> findAll(String q, String category, int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        boolean hasQ = q != null && !q.isBlank();
        boolean hasCat = category != null && !category.isBlank();

        if (hasQ && hasCat) return repo.findByCategoryIgnoreCaseAndNameContainingIgnoreCase(category, q, pageable);
        if (hasQ) return repo.findByNameContainingIgnoreCase(q, pageable);
        if (hasCat) return repo.findByCategoryIgnoreCase(category, pageable);

        return repo.findAll(pageable);
    }

    public Product findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));
    }

    public Product create(Product product) {
        product.setId(null); // por si llega algo raro
        return repo.save(product);
    }

    public Product update(Long id, Product updated) {
        Product existing = findById(id);
        existing.setName(updated.getName());
        existing.setBrand(updated.getBrand());
        existing.setCategory(updated.getCategory());
        existing.setPrice(updated.getPrice());
        existing.setStock(updated.getStock());
        existing.setDescription(updated.getDescription());
        existing.setImageUrl(updated.getImageUrl());
        return repo.save(existing);
    }

    public void delete(Long id) {
        Product existing = findById(id);
        repo.delete(existing);
    }
}