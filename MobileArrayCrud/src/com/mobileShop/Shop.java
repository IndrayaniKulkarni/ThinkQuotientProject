package com.mobileShop;

import java.util.Scanner;

/*
 * Create a Mobile store crud management

Add a mobile
Delete a mobile
Update price of mobile
View mobile by brand 
View all mobiles 

 */
public class Shop {
    static Scanner sc = new Scanner(System.in);
	static int num = 0;
	
	public static void addMobile(Mobile m) {
		System.out.println("Model = ");
		m.setModel(sc.next());
		System.out.println("Price = ");
		m.setPrice(sc.nextFloat());
		System.out.println("Brand name = ");
		m.setBrandName(sc.next());
		System.out.println("Mobile added successfully..");
	}
	public static void deleteMobile(Mobile m[], String toDelete) {
		boolean flag = false;
		if(m[m.length-1].getModel().equals(toDelete) || m[m.length-1].getBrandName().equals(toDelete)) {
		 flag = true;
		 System.out.println("Entry to be removed = "+m[m.length-1]);
			m[m.length-1]=null;
			num--;
		}
		for(int i=0; i<m.length-1; i++) {
//			if(m[i].getModel()!=null){
			if(m[i].getModel().equals(toDelete) || m[i].getBrandName().equals(toDelete)) {
				flag = true;
				System.out.println("Entry to be removed = "+m[i]);
				m[i]=m[i+1];
				num--;
				break;
			}
			m[m.length-1]=null;
		}
		if(!flag) {
			System.out.println("Entry deleted ...");
		}
	}
	public static void updateMobile(Mobile m[], String toDelete) {
		boolean flag = false;
		
		for(int i=0; i<m.length; i++) {
			if(m[i].getModel().equals(toDelete) || m[i].getBrandName().equals(toDelete)) {
				flag = true;
				System.out.println("Entry to be updated = "+m[i]);
				addMobile(m[i]);
				break;
			}
		}
		if(!flag) {
			System.out.println("Entry updated ...");
		}
	}
	public static void displayAll(Mobile m[]) {
		System.out.println("\tModel\tPrice\tBrand");
		for(int i=0; i<m.length; i++) {
			System.out.println("\t"+m[i].getModel()+"\t"+m[i].getPrice()+"\t"+m[i].getBrandName());
		}
		System.out.println("------------------------------------------------------------");
	}
	public static void main(String[] args) {
		
		int choice;
		char yOrN = 'n';
		System.out.println("Number of orders = ");
		int order = sc.nextInt();
		Mobile m[] = new Mobile[order];
//		for(int i=0; i<order; i++) {
//			m[i] = new Mobile();
//		}
		do {
		System.out.println("----------------------MOBILE SHOP---------------------");
		System.out.println("1. Add a mobile");
		System.out.println("2. Delete a mobile");
		System.out.println("3. Update price of mobile");
		System.out.println("4. View all mobiles");
		System.out.println("5. Exit");
		System.out.println("Choice = ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1: //add
			if(num<order) {
				m[num] = new Mobile();
				addMobile(m[num]);
				num++;
			}
			else {
				System.out.println("Sorry you have reached number of orders..");
			}
			break;
		case 2://delete
			System.out.println("1. Model");
			System.out.println("2. Brand");
			System.out.println("Which you wish to remove from data = ");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1: System.out.println("Model = ");
					String model = sc.next();
				    deleteMobile(m,model);
				    break;
			case 2: System.out.println("Brand = ");
					String brand = sc.next();
					deleteMobile(m,brand);
			}
			break;
		case 3://update
			System.out.println("1. Model");
			System.out.println("2. Brand");
			System.out.println("Which you wish to update from data = ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1: System.out.println("Model = ");
					String model = sc.next();
				    updateMobile(m,model);
				    break;
			case 2: System.out.println("Brand = ");
					String brand = sc.next();
					updateMobile(m,brand);
			}
			break;
		case 4: //display
			displayAll(m);
			break;
		case 5 : break;
		}
		System.out.println("\n*Do you want to continue ? (y/Y) = ");
		yOrN = sc.next().charAt(0);
		System.out.println("------------------------------------------------------------");
		}while(yOrN=='y'|| yOrN =='Y');
	}

}
