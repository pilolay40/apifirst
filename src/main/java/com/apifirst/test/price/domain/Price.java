package com.apifirst.test.price.domain;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Price {

    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return this.brandId;
    }

    public void setBrandId(final Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getPriceList() {
        return this.priceList;
    }

    public void setPriceList(final Integer priceList) {
        this.priceList = priceList;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }
}
