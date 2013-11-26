package by.zti.game.gameobject;

import org.lwjgl.input.Keyboard;

import by.zti.GameObject;
import by.zti.game.gameobject.item.Item;


public class Player extends GameObject{
	public static final int SIZE = 42;
	public static final double LEVEL_CONSTANT = 25 + Math.pow(3.0, (3.0/2.0));
	private float xp;
	private int health;
	
	public Player(float x, float y){
		initialise(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
		xp=0;
		health = 10;
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
		return 4f; //TODO алгоритм скорости
	}
	
	public int getLevel(){
		double x = xp + 105;
		double a = Math.sqrt(243 * (x*x) + 4050 * x + 17500);
		double c = (3 * x +25)/25;
		double d = Math.cbrt(a / LEVEL_CONSTANT + c);
		return (int)(d - 1.0/d*3) -2;
	}
	
	public int getMaxHelth(){
		return (int)getLevel() * 10;
	}
	
	public int getCurrentHealth(){
		int max = getMaxHelth();
		if(health>max){
			health = max;
		}
		return health;
	}
	

	public void updtae(){
		
	}
	
	public float getStrength(){
		return getLevel() * 4f;
	}
	
	public float getMagic(){
		return getLevel() * 4f;
	}
	
	public void addXp(float amount){
		xp += amount;
	}
	
	public void addItem(Item item){
		System.out.println("you just picked up an item");
	}
}
