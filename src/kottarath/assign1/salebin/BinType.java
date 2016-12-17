package kottarath.assign1.salebin;

import kottarath.assign1.money.USMoney;

interface BinType {
	void addItem (ItemType item);
	USMoney calculatePrice();
	double getWeight();
	int getNoOfItems();
	String showDetails();

}
