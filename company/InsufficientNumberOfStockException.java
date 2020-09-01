package com.company;

public class InsufficientNumberOfStockException extends Exception {
    private Stock stock;
    private int quantity;
    private Store store;

    public InsufficientNumberOfStockException(Stock stock, int quantity, Store store) {
        this.stock = stock;
        this.quantity = quantity;
        this.store = store;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        int index = store.storeStockList.indexOf(stock);
        return "InsufficientNumberOfStockException: Lack of " + stock.getStockName() + "." +
                " There is a shortage of " + (quantity - store.storeStockList.get(index).getQuantity()) + ".";
    }
}
