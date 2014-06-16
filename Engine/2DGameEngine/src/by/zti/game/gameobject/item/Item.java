package by.zti.game.gameobject.item;

import by.zti.GameObject;
import by.zti.Physics;
import by.zti.Sprite;
import by.zti.game.gameobject.Player;

public class Item extends GameObject{
	protected String name;
	protected Player player;
	
	public Item(Player player){
		this.player = player;
	}
	
	public void pickUp(){
		System.out.println("You just pick up "+name+"!");
		player.addItem(this);
		remove();
	}
	
	public void updtae() {
		if(Physics.checkCollision(this, player)){
			pickUp();
		}		
	}
	
	protected void initialise(float x, float y, float r, float g, float b, float sizeX, float sizeY, String name){
		this.x = x;
		this.y = y;
		this.type = 1;
		this.sprite = new Sprite(r, g, b, sizeX, sizeY);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
