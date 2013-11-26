package by.zti;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

public abstract class GameObject {
	protected float x;
	protected float y;
	protected int type;
//	private Animation animation;
	protected Sprite sprite;
	protected boolean flags[] = new boolean[1];
	
	public void updtae(){
		
	}
	
	protected void initialise(float x, float y, float r, float g, float b, float sizeX, float sizeY, int type){
		this.x = x;
		this.y = y;
		this.type = type;
		this.sprite = new Sprite(r, g, b, sizeX, sizeY);
	}
	
	public int getTypr(){
		return type;
	}
	
	public void render(){
		glPushMatrix(); // Вывод в отдельную матрицу
		{
		glTranslatef(x, y, 0);
		sprite.render();
		}
		glPopMatrix(); //Возврат в основную матрицу
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public float getSizeX() {
		return sprite.getSizeX();
	}

	public float getSizeY() {
		return sprite.getSizeY();
	}
	
	public void remove(){
		flags[0] = true;
	}

	public boolean isRemove() {
		return flags[0];
	}
}
