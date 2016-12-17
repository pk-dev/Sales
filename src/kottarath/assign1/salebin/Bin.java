package kottarath.assign1.salebin;

import java.util.Arrays;
import kottarath.assign1.money.USMoney;

public class Bin implements BinType{

	//data members
	private String binNumber;
	private ItemType[] items=new ItemType[3];
	private int itemCounter=0;//Stores the number of items in array. Used to add items to array.
	protected static final double MAXWEIGHT=100;
	protected static final int BIN_COST=100;
	private static int counter=0;
	
	
	//getters
	public String getBinNumber()
	{
		return binNumber;
	}
	protected ItemType[] getItems()
	{
		return Arrays.copyOf(items, items.length);
	}
	
	//setters
	public void setBinNumber(String prefix)
	{
		binNumber=generateBinNumber(prefix);
	}
	protected void setItems(ItemType newItem)
	{
		//if array size exceeds, copy to a new array with double the size
		if(items.length==itemCounter)
		{
			items=Arrays.copyOf(items, items.length*2);
		}
		
		//add new item to array
		items[itemCounter]=newItem;
		itemCounter++;//increments value to indicate next index of array that is available.
		
		
	}
	
	//Constructors
	public Bin()
	{
		setBinNumber("BIN");
	}
	public Bin(String prefix)
	{
		setBinNumber(prefix);
	}
	
	//Methods
	
	/**
	 * Append a unique number to prefix and generate binNumber.
	 * @param prefix String
	 * @return String 
	 */
	public static String generateBinNumber(String prefix)
	{
		//counter variable is used to generate unique bin number
		counter++;
		return prefix+counter;
		
	}
	
	/**
	 * Checks the weight of the item and 
	 * if adding it to the bin does not exceed Bin’s maxWeight, 
	 * and if the item is not fragile, 
	 * adds it to the array, items.
	 * @author Priya
	 * @param ItemType interface
	 * 
	 */
	@Override
	public void addItem(ItemType item) {
		if(item.getWeight()<=0)
			System.out.println("Error: Weight of the item must be greater than zero. " +((SaleItem)item).getItemName()+" could not be added.");
		else{	
			if(!item.isFragile())
			{
				if(!((item.getWeight()+this.getWeight())>MAXWEIGHT))
				{
					setItems(item);
				}
				else
					System.out.println("Sorry, your bin reached its maximum capacity. "+((SaleItem)item).getItemName()+" could not be added.");
			}
			else
				System.out.println("Sorry,"+ ((SaleItem)item).getItemName() +" is fragile and can not be added to bin.");
		}
		
	}

	/**
	 * Calculates the total price of all items in items list and 
	 * adds the bin cost and returns the total cost of the bin.
	 * @author Priya
	 * @return USMoney class
	 * 
	 */
	@Override
	public USMoney calculatePrice() {
		//adds the bin cost
		USMoney totalCost=new USMoney(BIN_COST,0);
		//calculate the total price of all items in items list
		for(ItemType newItem :getItems())
		{
			if(newItem!=null)
			{
				USMoney money=newItem.getPrice();
				totalCost.addTo(money.getDollars(), money.getCents());
			}
		}
		return totalCost;
	}
	

	/**
	 * Get total weight of the bin.
	 * @author Priya
	 * @return double 
	 */
	@Override
	public double getWeight() {
		double totalWeight=0;
		
			for(ItemType newItem :getItems())
			{
				if(newItem!=null)
					totalWeight+=newItem.getWeight();
			}
		return totalWeight;
	}

	/**
	 * Get the number of items in bin
	 * @author Priya
	 * @return integer -total number of items in the bin
	 */
	@Override
	public int getNoOfItems() {
		return itemCounter;
	}

	/**
	 * Concatenates the binNumber,currentWeight and total cost of bin.
	 * @author Priya
	 * @return String 
	 */
	@Override
	public String showDetails() {
		// returns a string by concatenating the binNumber,currentWeight and total cost.
		return getBinNumber()+","+getWeight()+","+calculatePrice();
		
	}
	
	/**
	 * Gets a string representation of the object invoked on.
	 * @author Priya
	 * @return String 
	 */
	@Override
	public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Bin:"+showDetails()+"\n");
        sb.append("Item count:"+getNoOfItems()+"\n");
        sb.append("Items:");
        for(ItemType newItem:getItems())
        {
        	if(newItem!=null)
        		sb.append(newItem.getDetails()+", ");
        }
        //remove trailing comma
        return sb.toString().replaceAll(", $", "");
    }
	

}
