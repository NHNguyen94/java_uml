package org.bank.datamodel;

public class Stock {
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    private String stockName;
    private Double stockPrice;

    public Stock(String name, Double price) {
        stockName = name;
        stockPrice = price;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", stockPrice=" + stockPrice +
                '}';
    }
}
