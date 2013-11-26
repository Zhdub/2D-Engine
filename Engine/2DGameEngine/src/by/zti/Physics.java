package by.zti;

import java.awt.Rectangle;

public class Physics {
	
	public static boolean checkCollision(GameObject gObj1, GameObject gObj2){
		Rectangle r1 = new Rectangle((int)gObj1.getX(), (int)gObj1.getSizeX(), (int)gObj1.getY(), (int)gObj1.getSizeY());
		Rectangle r2 = new Rectangle((int)gObj2.getX(), (int)gObj2.getSizeX(), (int)gObj2.getY(), (int)gObj2.getSizeY());
		return r1.intersects(r2);
	}
}
