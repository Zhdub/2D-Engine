package by.zti.engine.core.render;

import static org.lwjgl.opengl.GL11.*;

import java.io.Serializable;

import by.zti.engine.core.Textures;

public class Frame implements Serializable{
	private String textureName;
	private int duration;

	public Frame(String textureName, int duration) {
		this.textureName = textureName;
		this.duration = duration;
	}

	public void render(float width, float heigth) {
		Textures.getTexture(textureName).bind();
		glBegin(GL_QUADS);
		{
			glVertex2f(0, 0);
				glTexCoord2f(0, 0);
				
			glVertex2f(0, heigth);
				glTexCoord2f(0, 1);
			
			glVertex2f(width, heigth);
				glTexCoord2f(1, 1);
			
			glVertex2f(width, 0);
				glTexCoord2f(1, 0);
		}
		glEnd();
	}
	
	public int getDuration(){
		return duration;
	}

}
