package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private static int staticSerialNumber = 1;
    private int serialNumber;
    private Cashier cashier;
    private String dateAndHour;
    private List<Stock> receiptStockList;
    private int numberOfReceiptsToDate;
    private double totalPrice;

    public Receipt(Cashier cashier) {
        this.serialNumber = staticSerialNumber;
        this.cashier = cashier;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateAndHour = ldt.format(dtf);

        this.receiptStockList = new ArrayList<>();
        this.numberOfReceiptsToDate = staticSerialNumber;
        Store.setNumberOfReceipts(numberOfReceiptsToDate);
        staticSerialNumber++;
    }

    public void writeInFile() {
        try (FileWriter fw = new FileWriter("Receipt #" + this.serialNumber)) {
            fw.write(this + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStock(Stock stock, int quantity) {
        this.receiptStockList.add(stock);

        int index = this.receiptStockList.indexOf(stock);
        this.receiptStockList.get(index).setQuantity(quantity);

        totalPrice += stock.getStockPrice() * quantity;
    }

    public static int getStaticSerialNumber() {
        return staticSerialNumber;
    }

    public static void setStaticSerialNumber(int staticSerialNumber) {
        Receipt.staticSerialNumber = staticSerialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }

    public void setDateAndHour(String dateAndHour) {
        this.dateAndHour = dateAndHour;
    }

    public List<Stock> getReceiptStockList() {
        return receiptStockList;
    }

    public void setReceiptStockList(List<Stock> receiptStockList) {
        this.receiptStockList = receiptStockList;
    }

    public int getNumberOfReceiptsToDate() {
        return numberOfReceiptsToDate;
    }

    public void setNumberOfReceiptsToDate(int numberOfReceiptsToDate) {
        this.numberOfReceiptsToDate = numberOfReceiptsToDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString(){

        String header =  String.format(" %-20s\n %-9s %-13s %7s\n %-15s %5s %10s\n %-15s %5s %10s\n",

                dateAndHour, "Cashier:",cashier.getCashierName(), cashier.getCashierId(),

                "Item", "Qty", "Price",

                "----", "---", "-----");

        String content = "";

        for (Stock x:receiptStockList){

            content += String.format(" %-15s %5d %10.2f\n", x.getStockName(), x.getQuantity(), x.getStockPrice());

        }

        String footer = String.format(" %-15s %5s %10s\n %-15s %16.2f",

                "----", "---", "-----",

                "Total", totalPrice);



        return header + content + footer;

    }

    /*@Override
    public String toString() {
        return "Receipt{" +
                "serialNumber=" + serialNumber +
                ", cashier=" + cashier +
                ", dateAndHour='" + dateAndHour + '\'' +
                ", receiptStockList=" + receiptStockList +
                ", numberOfReceiptsToDate=" + numberOfReceiptsToDate +
                ", totalPrice=" + totalPrice +
                '}';
    }*/
}
