package com.geekbrains.work16.services;

import com.geekbrains.work16.entities.Product;
import com.geekbrains.work16.entities.ProductStatistic;
import com.geekbrains.work16.repositories.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    private StatisticRepository statisticRepository;
    private ProductsService productsService;

    @Autowired
    public void setStatisticRepository(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    public void update(Long id){
        Product product = productsService.getById(id);
        ProductStatistic statistic = statisticRepository.findByProduct(product);
        if(statistic == null){
            statistic = new ProductStatistic(product, 1);
        }else{
            statistic.setViews(statistic.getViews() + 1);
        }
        statisticRepository.save(statistic);
    }

    public List<ProductStatistic> getStatistic(){
        return statisticRepository.findTop3ByOrderByViewsDesc();
    }
}
