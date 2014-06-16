package by.zti.engine.core;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Core {
	private static int WIDTH;
	private static int HEIGTH;

	public Core(int width, int heigth) {
		WIDTH = width;
		HEIGTH = heigth;
		initialiseDisplay();
		initialiseGL(); 
		initialiseGame();
		gameLoop(); 
	}

	private static void initialiseGame() {
		// TODO game intialisation
	}

	private static void gameLoop() {
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT); //Очистка буфера цветов, очистка экрана;
			glLoadIdentity();
			render();
			Display.update();
			Display.sync(60);
		}
		cleanUp();
	}

	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}

	private static void render() {
		try {
			Texture grass = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/grass2.png"));
		
		glPushMatrix();
		glTranslatef(200, 200, 0);
		glColor3f(1, 0, 0);
		grass.bind();
		glBegin(GL_QUADS);
		{
			
			
			

			glVertex2f(0, 0);
			glTexCoord2f(0, 0);
			glVertex2f(0, 100);
			glTexCoord2f(0, 1);
			glVertex2f(100, 100);
			glTexCoord2f(1, 1);
			glVertex2f(100, 0);
			glTexCoord2f(1, 0);
			
		}
		glEnd();
		glPopMatrix();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	private static void update() {
	
	}


	private static void initialiseGL() {
		glEnable(GL_TEXTURE_2D);
		glClearColor(0, 0, 0, 0);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0,0,Display.getWidth(),Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(),-1,1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
//		glClearColor(0, 0, 0, 0);
	}

	private static void initialiseDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGTH));
			Display.create();
			Keyboard.create();
			Mouse.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
}


}
