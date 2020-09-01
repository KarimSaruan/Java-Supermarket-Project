package com.company;

public class Main {

    public static void main(String[] args) {
    	// Creating some stocks
    	Stock hlqb = new Stock("Hlqb", 0, 0.90, "01-04-2020");
	    Stock mlqko = new Stock("Mlqko", 0, 2.50, "17-05-2020");
	    Stock bonboni = new Stock("Bonboni", 0, 1.50, "23-03-2025");
	    Stock bira = new Stock("Bira", 0, 3.00, "06-04-2024");
	    Stock sujuk = new Stock("Sujuk", 0, 6.50, "06-03-2020");
	    Stock fanta = new Stock("Fanta", 0, 1.20, "11-07-2023");
	    Stock pampersi = new Stock("Pampersi", 0, 9.90, "05-10-2024");
	    Stock mayoneza = new Stock("Mayoneza", 0, 1.50, "03-14-2022");

	    // Creating a store
	    Store fantastiko = new Store();

	    // Filling the store with stocks
	    fantastiko.deliveryStock(hlqb, 1000);
	    fantastiko.deliveryStock(mlqko, 1000);
	    fantastiko.deliveryStock(bonboni, 1000);
	    fantastiko.deliveryStock(bira, 1000);
	    fantastiko.deliveryStock(sujuk, 1000);
	    fantastiko.deliveryStock(fanta, 1000);
	    fantastiko.deliveryStock(pampersi, 1000);
	    fantastiko.deliveryStock(mayoneza, 1000);

	    // Creating cashiers
		Cashier mitko = new Cashier("Mitko");
        Cashier gosho = new Cashier("Gosho");
		Cashier ralica = new Cashier("Ralica");
		Cashier nelina = new Cashier("Nelina");

		// Creating cash registers (these objects are used for the threads)
		CashRegister mitkoCashRegister = new CashRegister(mitko, fantastiko);
		CashRegister goshoCashRegister = new CashRegister(gosho, fantastiko);
		CashRegister ralicaCashRegister = new CashRegister(ralica, fantastiko);
		CashRegister nelinaCashRegister = new CashRegister(nelina, fantastiko);

		// Employing the cashiers in the store
		fantastiko.employCashier(mitko);
		fantastiko.employCashier(gosho);
		fantastiko.employCashier(ralica);
		fantastiko.employCashier(nelina);

		// Adding the cash register objects in the store
		fantastiko.addCashRegister(mitkoCashRegister);
		fantastiko.addCashRegister(goshoCashRegister);
		fantastiko.addCashRegister(ralicaCashRegister);
		fantastiko.addCashRegister(nelinaCashRegister);

		// Every cashier uses this method to scan
		// a given amount of quantity of a certain stock.
		// This method throws exception when there's not enough
		// stock in the store. For example there's 1000 bread in the
		// store and here we request for 1020, so an exception
		// will be thrown.
		mitkoCashRegister.scanStock(hlqb, 1020);
		mitkoCashRegister.scanStock(mlqko, 20);

		goshoCashRegister.scanStock(bonboni, 90);
		goshoCashRegister.scanStock(bira, 80);

		ralicaCashRegister.scanStock(sujuk, 25);
		ralicaCashRegister.scanStock(fanta, 40);

		nelinaCashRegister.scanStock(pampersi, 65);
		nelinaCashRegister.scanStock(mayoneza, 50);

		// Creates threads for each of the cash registers
		// and also creates txt files with the receipts
		// (prints cashier name and cash made in console also)
		fantastiko.sellStock();
	}
}
