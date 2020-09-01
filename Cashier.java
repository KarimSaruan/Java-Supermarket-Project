package com.company;

public class Cashier {
    private String cashierName;
    private String cashierId;

    public Cashier(String cashierName) {
        this.cashierName = cashierName;
        this.cashierId = "id#" + this.cashierName.toLowerCase();
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "cashierName='" + cashierName + '\'' +
                ", cashierId='" + cashierId + '\'' +
                '}';
    }
}
