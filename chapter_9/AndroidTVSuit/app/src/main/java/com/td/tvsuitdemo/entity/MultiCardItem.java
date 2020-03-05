package com.td.tvsuitdemo.entity;

import com.td.tvsuit.utils.adapter.SmartMultiEntity;

import java.util.List;

public class MultiCardItem extends SmartMultiEntity {
    private String name;
    private List<CardItem> cardItems;

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
