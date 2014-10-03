package by.zti.game;

import java.util.ArrayList;
import java.util.Scanner;

import by.zti.SerializationManager;
import by.zti.engine.Game;
import by.zti.engine.GameMap;
import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;

public class MainCopmonent {
	public static GameMap map = new GameMap();
	private static ArrayList<GameObject> current_objects = new ArrayList<GameObject>();
	private static WIP wip;
	private static GameCamera camera;
	
	public static void start3(){
		Core.start();
//		Core.addObject(wip);
//		while (true) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			for (GameObject object : Core.getObjects()) {
//				if (object.getX() > wip.getX() + 120 + wip.getWidth()-1
//						|| object.getX() < wip.getX() - 120 +1
//						|| object.getY() > wip.getY() + 120 + wip.getHeigth() -1
//						|| object.getY() < wip.getY() - 120 +1) {
//					Core.removeObject(object);
//				}
//			}
//			
//		}
		
		for(float i=wip.getX()-120;i<wip.getX()+120;i++){
			for(float k=wip.getY()-120;k<wip.getY()+120;k++){
				if(map.get(i, k)!=null){
					for(GameObject object: map.get(i, k)){
						Core.addObject(object);
					}
				}	
			}
		}
		while(true){
			for(float i=wip.getY()-120;i<wip.getY()+120;i++){
				if(map.get(wip.getX()+120, i)!=null){
					for(GameObject object: map.get(wip.getX()+120, i)){
						if(!current_objects.contains(object)&&!object.getClass().getSimpleName().contains("WIP")){
							current_objects.add(object);
						}
					}
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(GameObject object: current_objects){
				Core.addObject(object);
			}
		}
	}
	
	public static void start2(){
		Core.initialise();
		Core.setWidth(800);
		Core.setHeigth(600);
		camera = new GameCamera((800 / 2) - 20, (600 / 2) - 20, 4, 1);
		Core.setCamera(camera);
		camera.bind(wip);
		wip.resetAnimation(0);
	}
	
	public static void start(){
		map = (GameMap) SerializationManager.deSerializeData("Map", "gmp", "");
		Stats stats = (Stats) SerializationManager.deSerializeData("Stats",
				"sts", "");
		for (GameObject object : map.get(stats.getX(), stats.getY())) {
			if (object.getClass().getSimpleName().contains("WIP")) {
				wip = (WIP) object;
			}
		}
	}
	
	public static void main(String[] args) {
		start();
		start2();
		start3();
		
	}
}

