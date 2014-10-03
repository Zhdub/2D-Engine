package by.zti.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.map.MultiKeyMap;

import by.zti.engine.core.GameObject;

public class GameMap implements Serializable{
	private MultiKeyMap<Float, ArrayList<GameObject>> map = new MultiKeyMap<>();
	private MultiKeyMap<Integer, ArrayList<GameObject>> collision = new MultiKeyMap<>();

	public void put(GameObject object) {
		if (map.get(object.getX(), object.getY()) != null) {
			map.get(object.getX(), object.getY()).add(object);
			if (collision.get((int) (object.getX() / 40),
					(int) (object.getY() / 40)) != null) {
				collision.get((int) (object.getX() / 40),
						(int) (object.getY() / 40)).add(object);
			} else {
				ArrayList<GameObject> collisions = new ArrayList<GameObject>();
				collisions.add(object);
				collision.put((int) (object.getX() / 40),
						(int) (object.getY() / 40), collisions);
			}
		} else {
			ArrayList<GameObject> objects = new ArrayList<GameObject>();
			objects.add(object);
			map.put(object.getX(), object.getY(), objects);
			if (collision.get((int) (object.getX() / 40),
					(int) (object.getY() / 40)) != null) {
				collision.get((int) (object.getX() / 40),
						(int) (object.getY() / 40)).add(object);
			} else {
				ArrayList<GameObject> collisions = new ArrayList<GameObject>();
				collisions.add(object);
				collision.put((int) (object.getX() / 40),
						(int) (object.getY() / 40), collisions);
			}
		}
	}

	public void put(float x, float y, GameObject object) {
		if (map.get(x, y) != null) {
			map.get(x, y).add(object);
			if (collision.get((int) (x / 40), (int) (y / 40)) != null) {
				collision.get((int) (x / 40), (int) (y / 40)).add(object);
			} else {
				ArrayList<GameObject> collisions = new ArrayList<GameObject>();
				collisions.add(object);
				collision.put((int) (x / 40), (int) (y / 40), collisions);
			}

		} else {
			ArrayList<GameObject> objects = new ArrayList<GameObject>();
			objects.add(object);
			map.put(x, y, objects);
			if (collision.get((int) (x / 40), (int) (y / 40)) != null) {
				collision.get((int) (x / 40), (int) (y / 40)).add(object);
			} else {
				ArrayList<GameObject> collisions = new ArrayList<GameObject>();
				collisions.add(object);
				collision.put((int) (x / 40), (int) (y / 40), collisions);
			}
		}
	}

	public ArrayList<GameObject> get(float x, float y) {
		return map.get(x, y);
	}

	public ArrayList<GameObject> getCollision(float x, float y) {
		int i_x = (int) (x / 40);
		int i_y = (int) (y / 40);
		return collision.get(i_x, i_y);
	}

	public void remove(GameObject object) {
		float x = object.getX();
		float y = object.getY();
		int i_x = (int) (x / 40);
		int i_y = (int) (y / 40);
		for(GameObject map_object: map.get(x, y)){
			if(map_object.equals(object)){
				map.get(x, y).remove(map_object);
				break;
			}
		}
		for(GameObject collision_object: collision.get(i_x, i_y)){
			if(collision_object.equals(object)){
				collision.get(i_x, i_y).remove(collision_object);
				break;
			}
		}
	}

	public void remove(float x, float y) {
		map.removeAll(x, y);
		collision.removeAll(x, y);
	}

	public int size() {
		return map.size();
	}
	
	public ArrayList<GameObject> getAll(){
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		for(ArrayList<GameObject> list: map.values()){
			for(GameObject object: list){
				objects.add(object);
			}
		}
		return objects;
	}

	public boolean isGameMapValid() {
		if (map.size() == collision.size()) {
			return true;
		} else {
			return false;
		}
	}

}