package org.medmota.testsqli.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoinMachine {

	double total = 0.0;
	Map<Integer, Integer> myMap = new HashMap<>();
	
	public void putMoneyInside(String input) {
		String[] facteurs = input.split("x");
		Integer keyValue = Integer.parseInt(facteurs[1]);

		this.myMap.put(keyValue, Integer.parseInt(facteurs[0]));

		this.total += keyValue * this.myMap.get(keyValue);
	}

	public double totalMoney() {
		return this.total;
	}

	public Integer check(int value) {
		return this.myMap.get(value);
	}

	public void getMoney(int value) {
		Set<Integer> keySet = ((HashMap<Integer, Integer>) this.myMap).keySet();
		Integer[] myKeysAsArrays =  keySet.toArray(new Integer[keySet.size()]);
		Arrays.sort(myKeysAsArrays);
		int indexOfmaxCoin = myKeysAsArrays.length - 1;
		while (value >= myKeysAsArrays[0]) {
			Integer maxCoin = myKeysAsArrays[indexOfmaxCoin];
			if (value >= maxCoin) {
				value -= maxCoin;
				this.myMap.put(maxCoin, (this.myMap).get(maxCoin) - 1);
			} else if (value < myKeysAsArrays[indexOfmaxCoin]) {
				indexOfmaxCoin--;
				continue;
			}
		}

	}

}
