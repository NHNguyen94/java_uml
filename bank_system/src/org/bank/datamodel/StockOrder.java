package org.bank.datamodel;

import java.time.ZonedDateTime;

public class StockOrder {
    InvestmentAccount account;
    Stock stockUnit;
    Integer stockQuantity;
    Double unitPrice;
    Double totalPrice;
    Double commission;
    ZonedDateTime date;

    public StockOrder(InvestmentAccount acc, Stock stock, Integer qty, Double com, ZonedDateTime d) {
        this.account = acc;
        this.stockUnit = stock;
        this.stockQuantity = qty;
        this.unitPrice = stock.getStockPrice();
        this.commission = com;
        this.totalPrice = qty * this.unitPrice + this.commission;
        this.date = d;
    }

    @Override
    public String toString() {
        return "StockOrder{" +
                "account=" + account +
                ", stockUnit=" + stockUnit +
                ", stockQuantity=" + stockQuantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", commission=" + commission +
                ", date=" + date +
                '}';
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getCommission() {
        return commission;
    }
}
