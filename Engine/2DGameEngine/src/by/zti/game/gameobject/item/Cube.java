package by.zti.game.gameobject.item;

import by.zti.Physics;
import by.zti.game.gameobject.Player;

public class Cube extends Item{
	public static final float SIZE = 32;
	private Player player;
	
	public Cube(float x, float y, Player player){
		initialise(x, y, 1.0f, 0.8f, 0f, SIZE, SIZE, "The Cube");
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
}
