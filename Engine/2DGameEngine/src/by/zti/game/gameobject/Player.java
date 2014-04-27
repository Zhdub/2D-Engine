package by.zti.game.gameobject;

import org.lwjgl.input.Keyboard;

import by.zti.GameObject;
import by.zti.Sprite;
import by.zti.game.Stats;
import by.zti.game.Textures;
import by.zti.game.gameobject.item.Item;


public class Player extends GameObject{
	public static final int SIZE = 40;
	private Stats stats;
	private Inventory inventory;
	
	public Player(float x, float y){
		initialise(x, y, 0.1f, 0f, 0.5f, SIZE, SIZE, 0, new Sprite(0,0,0, SIZE, SIZE, Textures.player));
		stats = new Stats(0);
		inventory = new Inventory(20);
	}
	
	public void getInput(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			move(0,1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			move(0,-1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			move(-1,0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			move(1,0);
		}
	}

	private void move(int magX, int magY) {
		x += getSpeed() * magX;
		y += getSpeed() * magY;
	}
	
	public float getSpeed(){
		return stats.getSpeed();
	}
	
	public int getLevel(){
		return stats.getLevel();
	}
	
	public int getMaxHelth(){
		return stats.getMaxHelth();
	}

	public float getStrength(){
		return stats.getStrength();
	}
	
	public int getCurrentHealth(){
		return stats.getCurrentHealth();
	}
	
	public float getMagic(){
		return stats.getMagic();
	}
	
	public void addXp(float amount){
		stats.addXp(amount);
	}
	
	public void addItem(Item item){
		inventory.add(item);
	}
	
	public void updtae(){
		
	}
}
