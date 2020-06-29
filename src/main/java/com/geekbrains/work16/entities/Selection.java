package com.geekbrains.work16.entities;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Selection {
    private String titlesPart;
    private double priceMin;
    private double priceMax;

    @PostConstruct
    private void initSelection() {
        titlesPart = "";
        priceMin = 0;
        priceMax = Double.MAX_VALUE;
    }

    public String getTitlesPart() {
        return titlesPart;
    }

    public void setTitlesPart(String titlesPart) {
        this.titlesPart = titlesPart;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }

    public double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(double priceMax) {
        if (priceMax == 0) {
            this.priceMax = Double.MAX_VALUE;
        } else {
            this.priceMax = priceMax;
        }
    }
}
