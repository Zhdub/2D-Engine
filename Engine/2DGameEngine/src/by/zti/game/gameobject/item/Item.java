package by.zti.game.gameobject.item;

import by.zti.GameObject;
import by.zti.Sprite;

public class Item extends GameObject{
	protected String name;
	
	public void pickUp(){
		//TODO pickup sequencs
	}
	
	protected void initialise(float x, float y, float r, float g, float b, float sizeX, float sizeY, String name){
		this.x = x;
		this.y = y;
		this.type = 1;
		this.sprite = new Sprite(r, g, b, sizeX, sizeY);
		this.name = name;
	}
}
