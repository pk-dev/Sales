package kottarath.assign1.salebin;

import kottarath.assign1.money.USMoney;

public class SaleItem implements ItemType {
	//data members
	private String itemName;
	private USMoney price;
	private double weight;
	private boolean fragile;
	
	//getters
	public String getItemName()
	{
		return itemName;
	}
	public USMoney getPrice()
	{
		return price;
	}
	public double getWeight()
	{
		return weight;
	}
	public boolean getFragile()
	{
		return fragile;
	}
	
	//setters
	public void setItemName(String itemName)
	{
		this.itemName=itemName;
	}
	public void setPrice(USMoney price)
	{
		this.price=price;
	}
	public void setWeight(double weight)
	{
		this.weight=weight;
	}
	public void setFragile(boolean fragile)
	{
		this.fragile=fragile;
	}
	
	//Constructor
	public SaleItem(String itemName,USMoney price, double weight, boolean fragile)
	{
		setItemName(itemName);
		setPrice(price);
		setWeight(weight);
		setFragile(fragile);
		
	}
	
	//Methods
	/**
	 * Returna concatenated string itemName:price
	 * @author Priya
	 * @return String 
	 */
	public String getDetails(){
		return itemName+":"+price;
	}
	
	/**
	 * @author Priya
	 * @return boolean -the value of fragile
	 */
	public boolean isFragile()
	{
		return getFragile();
	}
	
	
	
}
