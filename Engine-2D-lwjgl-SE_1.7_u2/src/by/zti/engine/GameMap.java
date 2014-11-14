package by.zti.engine;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import by.zti.engine.core.GameObject;

public interface GameMap {
	
	public void putObject(GameObject object);
	public void removeObject(GameObject object);
	public void verifyMapWithObject(GameObject object);
	public ArrayList<GameObject> getObjects(float x, float y);
	public void removeAll(float x, float y);
	public int size();
	
}
