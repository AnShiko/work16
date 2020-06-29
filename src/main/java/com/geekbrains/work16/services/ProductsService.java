package com.geekbrains.work16.services;


import com.geekbrains.work16.entities.Product;
import com.geekbrains.work16.entities.Selection;
import com.geekbrains.work16.repositories.ProductRepository;
import com.geekbrains.work16.specifications.ProductsSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Selection selection, int page) {
        Specification<Product> spec = Specification.where(null);
        if (selection != null) {
            if (!selection.getTitlesPart().equals("")) {
                spec = spec.and(ProductsSpecs.titleContains(selection.getTitlesPart()));
            }
            if (selection.getPriceMin() != 0) {
                spec = spec.and(ProductsSpecs.priceLesserThanOrEq(selection.getPriceMin()));
            }
            if (selection.getPriceMax() < Double.MAX_VALUE) {
                spec = spec.and(ProductsSpecs.priceGreaterThanOrEq(selection.getPriceMax()));
            }
        }
        return productRepository.findAll(spec, PageRequest.of(page, 10));
    }
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(new Product(0L, "none", 0d));
    }
    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
