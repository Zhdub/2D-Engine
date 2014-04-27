package by.zti.game.gameobject.item;

import by.zti.Sprite;
import by.zti.game.Textures;
import by.zti.game.gameobject.Player;

public class Cube extends Item{
	public static final float SIZE = 40;
	
	public Cube(float x, float y, Player player){
		super(player);
		initialise(x, y, 1.0f, 0.8f, 0f, SIZE, SIZE, "The Cube", new Sprite(0,0,0,SIZE, SIZE, Textures.cube));
	}
}
