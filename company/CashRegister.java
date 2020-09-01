package com.company;

public class CashRegister {
    protected Cashier cashier;
    private Store store;
    private Receipt receipt;

    public CashRegister(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
        this.receipt = new Receipt(cashier);
    }

    public void scanStock(Stock stock, int quantity) {
        boolean flag_exception_occured = false;

        try {
            store.checkAvailability(stock, quantity);
        } catch (InsufficientNumberOfStockException e) {
            System.out.println(e.toString());
            flag_exception_occured = true;
        }

        if(!flag_exception_occured) {
            int index = store.storeStockList.indexOf(stock);
            store.storeStockList.get(index).setQuantity(store.storeStockList.get(index).getQuantity() - quantity);
            receipt.addStock(new Stock(stock), quantity);
        }
    }

    public void printReceipt() {
        System.out.printf("%s %.2f %s", cashier.getCashierName(), receipt.getTotalPrice(), "\n");
        receipt.writeInFile();
    }
}
