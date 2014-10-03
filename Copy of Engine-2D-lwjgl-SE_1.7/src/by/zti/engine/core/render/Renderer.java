package by.zti.engine.core.render;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;
import by.zti.engine.core.Textures;

public class Renderer implements Runnable {
	private boolean isRendering;

	@Override
	public void run() {
		initialiseDisplay();
		initialiseGL();
		Textures.loadTextures();
		isRendering = true;
		while (!Display.isCloseRequested()) {
			if (isRendering) {
				glClear(GL_COLOR_BUFFER_BIT);
				glLoadIdentity();
				render();
				Core.getCamera().update();
				Display.update();
				Display.sync(60);
				Core.getUpdater().tick();
				isRendering = false;
			}
		}
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		Core.setRunning(false);
	}
	
	public void tick() {
		if(!isRendering){
			isRendering = true;
		}
	}

	public void render() {
		for (GameObject object : Core.getObjects()) {
			if (object.getRender_layer() == 0) {
				object.render();
			}
		}
		for (GameObject object : Core.getObjects()) {
			if (object.getRender_layer() == 1) {
				object.render();
			}
		}
		for (GameObject object : Core.getObjects()) {
			if (object.getRender_layer() == 2) {
				object.render();
			}
		}
	}

	private static void initialiseDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(Core.getWidth(), Core
					.getHeigth()));
			Display.create();
			Keyboard.create();
			Mouse.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static void initialiseGL() {
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
		glClearColor(0, 0, 0, 0);
	}

	public boolean isRendering() {
		return isRendering;
	}

	public void setRendering(boolean isRendering) {
		this.isRendering = isRendering;
	}

}
