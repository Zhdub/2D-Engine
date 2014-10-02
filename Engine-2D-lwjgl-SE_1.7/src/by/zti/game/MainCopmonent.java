package by.zti.game;

import java.util.ArrayList;
import java.util.Scanner;

import by.zti.SerializationManager;
import by.zti.engine.Game;
import by.zti.engine.GameMap;
import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;

public class MainCopmonent {
	public static Core core;
	public static GameMap map = new GameMap();
	private static ArrayList<GameObject> current_objects = new ArrayList<GameObject>();
	private static WIP wip;
	private static GameCamera camera;

	public static void main(String[] args) {
//		
//		map = (GameMap) SerializationManager.deSerializeData("Map", "gmp", "");
//		for(GameObject object: map.getAll()){
//			if(object.getClass().getSimpleName().contains("WIP")){
//				wip = (WIP) object;
//			}
//		}
//		
//		core = new Core(800, 600);
//		camera = new GameCamera((800 / 2) - 20, (600 / 2) - 20, 4, 1);
//		core.setCamera(camera);
//		camera.bind(wip);
//		
//		for(GameObject object: map.getAll()){
//			Game.addObject(object);
//		}
		initialise();
		addObjectsToGame();

		
		
//		Scanner scn = new Scanner(System.in);
//		scn.nextLine();
		
//		SerializationManager.serializeData(map, "Map", "gmp", "");
	}

	public static void initialise() {
		core = new Core(800, 600);
		camera = new GameCamera((800 / 2) - 20, (600 / 2) - 20, 4, 1);
		Stone stone = new Stone(40, 40, core);
		Stone stone2 = new Stone(40, 120, core);
		WIP wip = new WIP(200, 200, core);
		camera.bind(wip);
		core.setCamera(camera);
		current_objects.add(stone);
		current_objects.add(stone2);
		current_objects.add(wip);
	}

	public static void addObjectsToGame() {
		for (GameObject object : current_objects) {
			Game.addObject(object);
		}
		for (int i = 0; i < 20; i++) {
			for (int k = 0; k < 15; k++) {
				Game.addObject(new Grass(i * 40, k * 40, core));
			}
		}
	}
}
