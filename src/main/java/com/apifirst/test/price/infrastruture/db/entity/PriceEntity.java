package com.apifirst.test.price.infrastruture.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "price")
@Table(name = "prices")
public class PriceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;

    @Column(name = "product_id")
    @NotNull
    private Integer productId;

    @Column(name = "brand_id")
    @NotNull
    private Integer brandId;

    @Column(name = "price_list")
    @NotNull
    private Integer priceList;

    @Column(name = "start_date")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    @NotNull
    private LocalDateTime endDate;

    @Column(name = "priority")
    @NotNull
    private Long priority;
    @Column(name = "price")
    @NotNull
    private Double price;

    @Column(name = "currency")
    @NotNull
    private String currency;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

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

    public Long getPriority() {
        return this.priority;
    }

    public void setPriority(final Long priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }
}
