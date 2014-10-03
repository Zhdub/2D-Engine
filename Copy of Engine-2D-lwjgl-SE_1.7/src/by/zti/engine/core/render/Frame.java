package by.zti.engine.core.render;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.Serializable;

import by.zti.engine.core.Textures;

public class Frame implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public int getDuration() {
		return duration;
	}

}
