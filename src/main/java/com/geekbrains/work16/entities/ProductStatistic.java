package com.geekbrains.work16.entities;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
public class ProductStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int views;

    public ProductStatistic(Product product, int views) {
        this.product = product;
        this.views = views;
    }

    public ProductStatistic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}