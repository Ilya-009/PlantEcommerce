package com.WebMall.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "storestats")
public class StoreStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer profit;

    private Integer goodsSold;

    private Integer diffCustomersCount;

    @OneToOne(mappedBy = "storeStats")
    private Store store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getGoodsSold() {
        return goodsSold;
    }

    public void setGoodsSold(Integer goodsSold) {
        this.goodsSold = goodsSold;
    }

    public Integer getDiffCustomersCount() {
        return diffCustomersCount;
    }

    public void setDiffCustomersCount(Integer diffCustomersCount) {
        this.diffCustomersCount = diffCustomersCount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
