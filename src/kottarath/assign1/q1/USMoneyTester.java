package kottarath.assign1.q1;

import kottarath.assign1.money.USMoney;

import kottarath.assign1.salebin.*;

public class USMoneyTester {

	public static void main(String[] args) {
		
		System.out.println("Question 1");
		assign1Q1TestCases();
		
		System.out.println();
		System.out.println("Question 2");
		assign1Q2TestCases();
		
	}
	
	/**
	 * Test cases for Assignment1 Question1
	 */
	private static void assign1Q1TestCases()
	{
		// Create instances and 
		// test the functionalities implemented in USMoney class
				
				System.out.println("First set of testing:");
				USMoney m1 = new USMoney (15,80);
				System.out.println (m1);
				m1.addTo(25,100);
				System.out.println (m1);
				USMoney m2 = m1.add( new USMoney (2,90));
				System.out.println (m2);
				System.out.println (m1);

				System.out.println();
				System.out.println("Second set of testing:");
				
				USMoney amt1=new USMoney();
				System.out.println(amt1);
				
				amt1.setCents(250);
				System.out.println(amt1);
				
				amt1.setDollars(10);
				System.out.println(amt1);
				
				System.out.println(amt1.getDollars());
				System.out.println(amt1.getCents());
				
				USMoney amt2=amt1.add(new USMoney(2,90));
				System.out.println(amt1);
				System.out.println(amt2);
				
				amt2.addTo(amt1.getDollars(), amt1.getCents());
				System.out.println(amt2);
				
				USMoney amt3=new USMoney(99,120);
				amt3.addTo(99, 120);
				System.out.println(amt3);
				
				
				System.out.println();
				System.out.println("Additional test cases:");
				
				USMoney newMoney=new USMoney(-100,-150);
				System.out.println(newMoney);//0.0
				newMoney.setCents(-25);
				System.out.println(newMoney);//0.0
				newMoney.setCents(100);
				System.out.println(newMoney);//1.0
				newMoney.setDollars(-10);
				System.out.println(newMoney);//1.0
				newMoney.setCents(0);
				newMoney.setDollars(0);
				System.out.println(newMoney);//0.0
				newMoney.addTo(5, -10);
				System.out.println(newMoney);//5.0
				newMoney.addTo(-12,125);
				System.out.println(newMoney);//6.25
				
				System.out.println(newMoney.add(new USMoney(-10,-85)));//6.25
				
				
	}

	/**
	 * Test cases for Assignment1 Question2
	 */
	private static void assign1Q2TestCases()
	{
		SaleItem[] saleItems={new SaleItem("Pen", new USMoney(5,25), 2, false),
							new SaleItem("Book",new USMoney(120,0),50,false),
							new SaleItem("Bottle",new USMoney(25,50),6.5,false),
							new SaleItem("Phone",new USMoney(500,100),6,true),
							new SaleItem("Mug",new USMoney(25,0),20,false)};
		
		Bin bin1=new Bin();
		
		for(SaleItem newSaleItem:saleItems)
		{
			bin1.addItem(newSaleItem);
		}
		System.out.println(bin1.showDetails());
		
		System.out.println();
		System.out.println("Showing the entire bin data:");
		System.out.println(bin1);
		
		//Test cases for Smart bin
		
		SaleItem[] newSaleItems={new SaleItem("Phone", new USMoney(450,25), 8, false),
				new SaleItem("Tablet",new USMoney(500,0),12,true),
				new SaleItem("Laptop",new USMoney(800,50),45,true),
				new SaleItem("Headset",new USMoney(100,100),3,false),
				new SaleItem("Charger",new USMoney(50,0),6,false)};
		
		SmartBin sbin1=new SmartBin();
		for(SaleItem newSaleItem:newSaleItems)
		{
			sbin1.addItem(newSaleItem);
		}
		
		System.out.println();
		System.out.println(sbin1.showDetails());
		
		System.out.println();
		System.out.println("Showing the entire smart bin data:");
		System.out.println(sbin1);
		
		Bin bin3=new SmartBin();
		SaleItem fragileS1=new SaleItem("Crystal",new USMoney(100,50),20,true);
		bin3.addItem(fragileS1);
		
		System.out.println();
		System.out.println(bin3);
		
		//Weight Validation
		System.out.println();
		Bin bin4=new Bin();
		SaleItem s2=new SaleItem("Chair",new USMoney(20,0),-20,false);
		bin4.addItem(s2);
		System.out.println(bin4);
		SmartBin sbin2=new SmartBin();
		sbin2.addItem(s2);
		System.out.println(sbin2);
		
	}
}
