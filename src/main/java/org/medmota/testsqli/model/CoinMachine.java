package org.medmota.testsqli.model;

import java.util.Map;
import java.util.TreeMap;

public class CoinMachine {

	double total = 0.0;

	Map<Integer, Integer> myMap = new TreeMap<>();

	public void putMoneyInside(String input) {
		String[] facteurs = input.split("x");
		Integer keyValue = Integer.parseInt(facteurs[1]);

		myMap.put(keyValue, Integer.parseInt(facteurs[0]));

		this.total += keyValue * myMap.get(keyValue);
	}

	public double totalMoney() {
        for (Integer name : this.myMap.keySet()) 
            System.out.println("key: " + name);
		return this.total;
	}

	public Integer check(int value) {
		return this.myMap.get(value);
		 
	}

	public void getMoney(int value) {
		while(value >0) {
			int maxCle = this.myMap.keySet().stream().max(Integer::compareTo).orElse(0);
			if(value >= maxCle /*&& */) {
				 value-=maxCle;
				 int currentValue = (this.myMap).get(maxCle);
				 this.myMap.put(maxCle, currentValue- 1);
				
				
			}
			else if(value % maxCle == 0) {
				value-=maxCle;
			}
		}
		
	}

}
