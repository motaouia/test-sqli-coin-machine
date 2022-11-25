package org.medmota.testsqli.model;

public class CoinMachine {
	
	double total = 0.0;
	
	public void putMoneyInside(String input) {
		String[] facteurs = input.split("x");
		
		double firstFacteur = Double.parseDouble(facteurs[0]);
		double secondFacteur = Double.parseDouble(facteurs[1]);

		this.total+= firstFacteur * secondFacteur;
	}
	
	public double totalMoney() {
		return this.total;
	}
	
	public int check(int value) {
		return 0;
	}
	
	public void getMoney(int value) {
		
	}

}
