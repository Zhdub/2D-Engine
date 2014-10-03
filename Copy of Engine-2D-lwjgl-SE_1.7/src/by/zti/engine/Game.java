package by.zti.engine;

import java.util.ArrayList;

import by.zti.engine.core.GameObject;

public class Game {
	private static boolean isObjectsChanged;
	private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public static synchronized ArrayList<GameObject> getObjects(){
		ArrayList<GameObject> rturn_objects = new ArrayList<GameObject>();
		rturn_objects.addAll(objects);
		return rturn_objects;
	}
	
	public static void addObject(GameObject object){
		objects.add(object);
		isObjectsChanged = true;
	}
	
	public static void removeObject(GameObject object){
		objects.remove(object);
		isObjectsChanged = true;
	}
	
	public static void removeObject(int objectIndex){
		objects.remove(objectIndex);
		isObjectsChanged = true;
	}

	public static boolean isObjectsChanged() {
		return isObjectsChanged;
	}

	public static void setObjectsChanged(boolean isObjectsChanged) {
		Game.isObjectsChanged = isObjectsChanged;
	}
	
	public static void removeAll(){
		objects.clear();
	}

}
