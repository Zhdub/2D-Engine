package by.zti;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

public class Sprite {
	private float r;
	private float g;
	private float b;
	
	private Texture texture;
	private float sizeX;
	private float sizeY;
	
	public Sprite(float r, float g, float b, float sizeX, float sizeY, Texture texture){
		this.r = r;
		this.g = g;
		this.b = b;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.texture=texture;
	}
	
	public void render() {
		//glColor3f(r, g, b);
		texture.bind();
		glBegin(GL_QUADS);
		{	
			glTexCoord2f(0, 1);
			glVertex2f(0, 0);
			glTexCoord2f(1, 1);
			glVertex2f(0, sizeY);
			glTexCoord2f(1, 0);
			glVertex2f(sizeX, sizeY);
			glTexCoord2f(0, 0);
			glVertex2f(sizeX, 0);
		}
		glEnd();
	}

	public float getSizeX() {
		return sizeX;
	}

	public float getSizeY() {
		return sizeY;
	}

	public void setSizeX(float sizeX) {
		this.sizeX = sizeX;
	}

	public void setSizeY(float sizeY) {
		this.sizeY = sizeY;
	}

}
