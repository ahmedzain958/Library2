package com.example.library2.designpatterns.linkedin.iteratorpattern.dinermerger;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu hashMapMenu;

	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu hashMapMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.hashMapMenu = hashMapMenu;
	}
 
	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator hashMapIterator = hashMapMenu.createIterator();

		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		System.out.println("\nHashMap");
		printMenu(hashMapIterator);

	}
 
	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
 
	public void printVegetarianMenu() {
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		printVegetarianMenu(dinerMenu.createIterator());
	}
 
	public boolean isItemVegetarian(String name) {
		Iterator breakfastIterator = pancakeHouseMenu.createIterator();
		if (isVegetarian(name, breakfastIterator)) {
			return true;
		}
		Iterator dinnerIterator = dinerMenu.createIterator();
		if (isVegetarian(name, dinnerIterator)) {
			return true;
		}
		return false;
	}


	private void printVegetarianMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName());
				System.out.println("\t\t" + menuItem.getPrice());
				System.out.println("\t" + menuItem.getDescription());
			}
		}
	}

	private boolean isVegetarian(String name, Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = iterator.next();
			if (menuItem.getName().equals(name)) {
				if (menuItem.isVegetarian()) {
					return true;
				}
			}
		}
		return false;
	}
}
