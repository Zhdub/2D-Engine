package by.zti.game.gameobject;

import by.zti.GameObject;
import by.zti.Sprite;
import by.zti.game.Textures;

public class Grass extends GameObject {
	public static final float SIZE = 40f;
	
	public Grass(float x, float y){
		initialise(x, y, 0f, 1f, 0f, SIZE, SIZE, type, new Sprite(0f,0f,0f,SIZE,SIZE,Textures.grass));
	}

}
