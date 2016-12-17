package kottarath.assign1.salebin;

import kottarath.assign1.money.USMoney;

/**
 * @author Priya
 *
 */
interface ItemType {
	boolean isFragile();
	USMoney getPrice();
	double getWeight();
	String getDetails();

}
