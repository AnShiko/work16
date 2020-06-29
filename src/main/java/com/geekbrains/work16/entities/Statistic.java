package com.geekbrains.work16.entities;

import com.geekbrains.work16.services.StatisticService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Statistic {
    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Before("execution(public String com.geekbrains.work16.controllers.ProductController.showOneProduct(..))")
    public void beforeShowOneProductMethodInProductsController(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        statisticService.update((long) args[1]);
    }
}