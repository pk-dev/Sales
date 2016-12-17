package kottarath.assign1.salebin;

import kottarath.assign1.money.USMoney;

public class SmartBin extends Bin{
	//data members
	private String label;
	private static final int FRAGILE_BIN_COST=10;
	
	//getter
	public String getLabel()
	{
		return label;
	}
	
	//setter
	public void setLabel(String label)
	{
		this.label=label;
	}
	
	//Constructor
	public SmartBin()
	{
		super("SM");
	}
	
	//Methods
	/**
	 * Checks the weight of the item and 
	 * if adding it to the bin does not exceed Bin’s maxWeight, 
	 * adds it to the array, items.
	 * If the item is fragile, set the label.
	 * @author Priya
	 * @param ItemType interface
	 * 
	 */
	@Override
	public void addItem(ItemType item) {
		if(item.getWeight()<=0)
			System.out.println("Error: Weight of the item must be greater than zero. " +((SaleItem)item).getItemName()+" could not be added.");
		else{
		//add to bin if the total weight of the bin does not exceed maxWeight
			if(!((item.getWeight()+this.getWeight())>MAXWEIGHT))
			{
				setItems(item);
				
				//If the item is fragile, set the label
				if(item.isFragile())
				{
					setLabel("Fragile - Handle with Care");
				}
			}
			else
				System.out.println("Sorry, your bin reached its maximum capacity. "+((SaleItem)item).getItemName()+" could not be added.");
		}
		
			
	}
	
	/**
	 * calculate the total price of all items in items list.
	 * Add cost of bin and a fixed addition cost to each fragile item in the bin.
	 * @author Priya
	 * @returns USMoney class
	 */
	@Override
	public USMoney calculatePrice()
	{
		
		//adds the bin cost
		USMoney totalCost=new USMoney(BIN_COST,0);
		//calculate the total price of all items in items list
		for(ItemType newItem :getItems())
		{
			if(newItem!=null)
			{
				USMoney money=newItem.getPrice();
				totalCost.addTo(money.getDollars(), money.getCents());
				
				//add $10 extra for each of the fragile items
				if(newItem.isFragile())
					totalCost.addTo(FRAGILE_BIN_COST,0);
				
			}
		}
		return totalCost;
	}
	
	/**
	 * Concatenating the binNumber,label,currentWeight and total cost of Items.
	 * @author Priya
	 * @return String
	 */
	@Override
	public String showDetails() {
		// returns a string by concatenating the binNumber,label,currentWeight and total cost of Items
		
		if(getLabel()==null)//label will only be set if bin contains a fragile item.
			return getBinNumber()+","+getWeight()+","+calculatePrice();
		
		return getBinNumber()+","+getLabel()+","+getWeight()+","+calculatePrice();
		
	}
	


}
