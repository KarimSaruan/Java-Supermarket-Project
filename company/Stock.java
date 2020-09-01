package com.company;

public class Stock {
    private String stockId;
    private String stockName;
    private double stockPrice;
    private String expiryDate;
    private int quantity;

    public Stock(String stockName, int quantity, double stockPrice, String expiryDate) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.stockPrice = stockPrice;
        this.expiryDate = expiryDate;
        this.stockId = "id#" + this.stockName.toLowerCase();
    }

    public Stock(Stock stock) {
        this.stockId = stock.stockId;
        this.stockName = stock.stockName;
        this.quantity = stock.quantity;
        this.stockPrice = stock.stockPrice;
        this.expiryDate = stock.expiryDate;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId='" + stockId + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockPrice=" + stockPrice +
                ", expiryDate='" + expiryDate + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
