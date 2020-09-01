package com.company;

import java.util.ArrayList;
import java.util.List;

public class Store {
    protected List<Stock> storeStockList;
    private List<Cashier> storeChashierList;
    private List<CashRegister> storeCashRegisterList;
    private static int numberOfReceipts;

    public Store() {
        this.storeStockList = new ArrayList<>();
        this.storeChashierList = new ArrayList<>();
        this.storeCashRegisterList = new ArrayList<>();
    }

    public void deliveryStock(Stock stock, int quantity) {
        if (storeStockList.contains(stock)) {
            int index = storeStockList.indexOf(stock);
            storeStockList.get(index).setQuantity(storeStockList.get(index).getQuantity() + quantity);
        } else {
            stock.setQuantity(quantity);
            storeStockList.add(stock);
        }
    }

    public void employCashier(Cashier cashier) {
        storeChashierList.add(cashier);
    }

    public void addCashRegister(CashRegister cashRegister) {
        storeCashRegisterList.add(cashRegister);
    }

    public void checkAvailability(Stock stock, int quantity) throws InsufficientNumberOfStockException {
        if (storeStockList.contains(stock)) {
            int index = storeStockList.indexOf(stock);
            if (quantity <= storeStockList.get(index).getQuantity()) {
                return;
            } else {
                throw new InsufficientNumberOfStockException(stock, quantity, this);
            }
        } else {
            System.out.println(stock.getStockName() + " is not available in the store now");
        }
    }

    synchronized public void  sellStock() {
        for (CashRegister x : storeCashRegisterList) {
            CashRegisterThread tr = new CashRegisterThread(this, x);
            Thread t = new Thread(tr);
            t.start();
        }
    }

    public List<Stock> getStoreStockList() { return storeStockList; }

    public List<Cashier> getStoreChashierList() { return storeChashierList; }

    public static int getNumberOfReceipts() {
        return numberOfReceipts;
    }

    public static void setNumberOfReceipts(int numberOfReceipts) {
        Store.numberOfReceipts = numberOfReceipts;
    }
}
