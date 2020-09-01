package com.company;

public class CashRegisterThread implements Runnable {
    private Store store;
    private CashRegister cashRegister;

    CashRegisterThread(Store store, CashRegister cashRegister) {
        this.store = store;
        this.cashRegister = cashRegister;
    }

    public void run() {
        cashRegister.printReceipt();
    }
}
