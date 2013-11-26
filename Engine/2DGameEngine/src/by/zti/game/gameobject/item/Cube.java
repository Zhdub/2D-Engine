package by.zti.game.gameobject.item;

import by.zti.game.gameobject.Player;

public class Cube extends Item{
	public static final float SIZE = 32;
	
	public Cube(float x, float y, Player player){
		super(player);
		initialise(x, y, 1.0f, 0.8f, 0f, SIZE, SIZE, "The Cube");
	}
}
