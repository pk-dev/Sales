package kottarath.assign1.money;

public class USMoney {
	
	//data members
	private int dollars;
	private int cents;
	
	//setters
	public void setDollars(int dollars)
	{
		if(dollars<0)
			System.out.println("Error: Dollar value cannot be negative.");
		else
			this.dollars=dollars;
	}
	
	public void setCents(int cents)
	{
		if(cents<0)
			System.out.println("Error: Cent value cannot be negative.");
		else if(cents < 100)
			this.cents=cents;
		else
			this.cents=calculateCents(cents);
			
	}
	
	//getters
	public int getDollars()
	{
		return dollars;
	}
	
	public int getCents()
	{
		return cents;
	}
	
	//Constructors
	public USMoney(){}
	
	public USMoney(int dollars,int cents)
	{
		setDollars(dollars);
		setCents(cents);
		
	}
	
	//Methods
	/**
	 * Converts cents to dollars if cents>99.
	 * @author Priya
	 * @param cents integer - value above 100
	 * @return cents integer - value after converting to dollars
	 */
	private int calculateCents(int cents)
	{
		int dollars= getDollars() + cents/100;
		setDollars(dollars);
		
		return cents%100;
	}
	
	/**
	 * Add the parameter values dollar and cents to the data members.
	 * @author Priya
	 * @param dollars integer
	 * @param cents integer
	 * 
	 */
	public void addTo(int dollars,int cents)
	{
		setDollars(getDollars()+dollars);
		setCents(getCents()+cents);
		
	}
	
	/**
	 * Creates and returns a new USMoney object 
	 * representing the sum of the object whose add() is invoked 
	 * and the object passed as parameter.
	 * @author Priya
	 * @param USMoney
	 * @return USMoney
	 * 
	 */
	public USMoney add(USMoney money)
	{
		USMoney newMoney=new USMoney(this.getDollars(),this.getCents());
		
		newMoney.addTo(money.getDollars(),money.getCents());
		
		return newMoney;
	}
	
	/**
	 * Returns a string representation of the object invoked on.
	 * @author Priya
	 * @return String 
	 */
	public String toString() {
        return "$"+getDollars() +"."+ getCents();
    }
	

}
