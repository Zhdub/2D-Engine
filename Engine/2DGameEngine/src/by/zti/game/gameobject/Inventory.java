package by.zti.game.gameobject;

import by.zti.game.gameobject.item.Item;

public class Inventory {
	private Item[] items;
	private int firstFree;
	
	public Inventory(int size){
		items = new Item[size];
		firstFree = 0;
	}
	
	public boolean add(Item item){
		if(firstFree==items.length)
			return false;
		
		items[firstFree] = item;
		for (int i = firstFree + 1; i < items.length; i++) {
			if(items[i]==null){
				firstFree = i;
				return true;
			}
		}
		firstFree = items.length;
		return true;
	}
	
	public void remove(int index){
		System.out.println("\nItem <"+items[index].getName()+"> removed from your inventory by index "+index+"\n");
		items[index] = null;
	}
	
	public void remove(Item item){
		for (int i = 0; i < items.length; i++) {
			if(items[i].equals(item)){
				items[i] = null;
				System.out.println("\nItem <"+item.getName()+"> removed from your inventory by index "+i+"\n");
			}
		}
	}
	
	public Item get(int index){
		return items[index];
	}
}
