package by.zti;

import static org.lwjgl.opengl.GL11.*; 

public abstract class GameObject {
	private float x;
	private float y;
//	private Animation animation;
	private Sprite sprite;
	
	public void updtae(){
		
	}
	
	public void render(){
		glPushMatrix(); // ����� � ��������� �������
		{
		glTranslatef(x, y, 0);
		sprite.render();
		}
		glPopMatrix(); //������� � �������� �������
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
}
