package org.medmota.testsqli.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoinMachine {

	double total = 0.0;
	Map<Integer, Integer> mapOfCoins = new HashMap<>();
	
	public void putMoneyInside(String input) {
		String[] facteurs = input.split("x");
		Integer coin = Integer.parseInt(facteurs[1]);

		this.mapOfCoins.put(coin, Integer.parseInt(facteurs[0]));

		this.total += coin * this.mapOfCoins.get(coin);
	}

	public double totalMoney() {
		return this.total;
	}

	public Integer check(int value) {
		return this.mapOfCoins.get(value);
	}

	public void getMoney(int value) {
		Set<Integer> coins = this.mapOfCoins.keySet();
		Integer[] arrayOfCoins =  coins.toArray(new Integer[coins.size()]);
		Arrays.sort(arrayOfCoins);
		int indexOfmaxCoin = arrayOfCoins.length - 1;
		while (value >= arrayOfCoins[0]) {
			Integer maxCoin = arrayOfCoins[indexOfmaxCoin];
			if (value >= maxCoin && this.mapOfCoins.get(maxCoin) >= 1) {
				value -= maxCoin;
				this.mapOfCoins.put(maxCoin, (this.mapOfCoins).get(maxCoin) - 1);
			} else if (value < maxCoin || check(maxCoin) <=0) {
				indexOfmaxCoin--;
			}
		}

	}

}
