package by.zti.engine.core;

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

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import by.zti.engine.Game;
import by.zti.engine.Input;
import by.zti.engine.core.render.Camera;
import by.zti.engine.core.render.Renderer;
import by.zti.engine.core.update.Updater;

public class Core implements Runnable, Serializable{
	private int WIDTH;
	private int HEIGTH;
	
	private Renderer renderer = new Renderer(this);
	private boolean isRunning; // true, если программа работает
	private Camera camera; // Ссылка на объект отвечающий за игровую камеру
	private ArrayList<GameObject> objects = new ArrayList<GameObject>(); // Ссылка на список объектов находящихся на обработке
	
	public Core(int width, int heigth) {
		WIDTH = width;
		HEIGTH = heigth;
		
		new Thread(this).start();
		
	}
	
	public void update(){
		for(GameObject object: objects){
			object.update();
		}
	}
	
	public void render(){ 
		camera.update();
		for(GameObject object: objects){
			if(object.getRender_layer()==0){
				object.render();
			}
		}
		for(GameObject object: objects){
			if(object.getRender_layer()==1){
				object.render();
			}
		}
		for(GameObject object: objects){
			if(object.getRender_layer()==2){
				object.render();
			}
		}
	}
	
 	public void initialiseDisplay() {
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
	
	public void initialiseGL() {
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0,0,Display.getWidth(),Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(),-1,1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
		glClearColor(0, 0, 0, 0);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialiseDisplay();
		initialiseGL();
		Textures.loadTextures();
		while(!Display.isCloseRequested()){
			if(Game.isObjectsChanged()){
				objects = Game.getObjects();
				Game.setObjectsChanged(false);
			}
			glClear(GL_COLOR_BUFFER_BIT); //ќчистка буфера цветов, очистка экрана;
			glLoadIdentity();
			Input.update();
			update();
			render();
//			renderer.tick(this);
			Display.update();
			Display.sync(60);
		}
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
