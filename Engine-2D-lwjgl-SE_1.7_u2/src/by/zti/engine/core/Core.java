package by.zti.engine.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;

import by.zti.engine.GameMap;
import by.zti.engine.core.render.Camera;
import by.zti.engine.core.render.Renderer;
import by.zti.engine.core.update.Updater;

public class Core {
	private static int width;
	private static int heigth;

	private static volatile boolean isRunning;
	private static Renderer renderer;
	private static Updater updater;
	private static Thread renderer_thread;
	private static Thread updater_thread;
	private static BlockingQueue<GameObject> queue;
	private static Camera camera;
	private static GameMap map;


	public static void initialise() {
		try{
			isRunning = true;
			setQueue(new ArrayBlockingQueue<GameObject>(60*60));
			renderer = new Renderer();
			updater = new Updater();
			setRenderer_thread(new Thread(renderer));
			setUpdater_thread(new Thread(updater));
		}catch (Exception e){
			if(camera==null){
				JOptionPane.showMessageDialog(null, "Ypu need to setup Game Camera");
				System.exit(0);
			}
		}
		
	}
	
	public static void start(){
		updater_thread.start();
		renderer_thread.start();
	}
	
	public static void addObject(GameObject object){
		queue.add(object);
	}
	
	public static void removeObject(GameObject object) {
		queue.remove(object);
	}

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		Core.isRunning = isRunning;
	}

	public static int getHeigth() {
		return heigth;
	}

	public static void setHeigth(int heigth) {
		Core.heigth = heigth;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Core.width = width;
	}

	public static Thread getRenderer_thread() {
		return renderer_thread;
	}

	public static void setRenderer_thread(Thread renderer_thread) {
		Core.renderer_thread = renderer_thread;
	}

	public static Thread getUpdater_thread() {
		return updater_thread;
	}

	public static void setUpdater_thread(Thread updater_thread) {
		Core.updater_thread = updater_thread;
	}

	public static Renderer getRenderer() {
		return renderer;
	}

	public static void setRenderer(Renderer renderer) {
		Core.renderer = renderer;
	}

	public static Updater getUpdater() {
		return updater;
	}

	public static void setUpdater(Updater updater) {
		Core.updater = updater;
	}

	public static Camera getCamera() {
		return camera;
	}

	public static void setCamera(Camera camera) {
		Core.camera = camera;
	}

	public static BlockingQueue<GameObject> getQueue() {
		return queue;
	}

	public static void setQueue(BlockingQueue<GameObject> queue) {
		Core.queue = queue;
	}

	public static GameMap getMap() {
		return map;
	}

	public static void setMap(GameMap map) {
		Core.map = map;
	}
}
