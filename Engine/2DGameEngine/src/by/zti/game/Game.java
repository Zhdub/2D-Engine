package by.zti.game;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import by.zti.GameObject;
import by.zti.game.gameobject.Player;
import by.zti.game.gameobject.item.Cube;

public class Game {
	private ArrayList<GameObject> objects;
	private ArrayList<GameObject> remove;
	private Player player;
	
	public Game(){
		objects = new ArrayList<GameObject>();
		remove = new ArrayList<GameObject>();
		player = new Player(Display.getWidth()/2 - Player.SIZE/2, Display.getHeight()/2 - Player.SIZE/2);
		objects.add(player);
		objects.add(new Cube(32,32, player));
	}
	
	public void getInput(){
		player.getInput();
	}
	
	public void update(){
		for(GameObject go: remove){
			objects.remove(go);
		}
		
		for(GameObject go: objects){
			if(!go.isRemove()){
				go.updtae();
			}else{
				remove.add(go);
			}
		}
	}
	
	public void render(){
		for(GameObject go: objects){
			go.render();
		}
	}
}
