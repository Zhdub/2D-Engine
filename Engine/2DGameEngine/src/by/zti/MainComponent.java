package by.zti;

import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import by.zti.game.Game;
import static org.lwjgl.opengl.GL11.*;

public class MainComponent {
	private static final int WIDTH = 800;
	private static final int HEIGTH = 600;
	private static Game game;
	
	public static void main(String[] args){
		init();
	}
	
	public static void init(){
		initialiseDisplay();  //Инициализация окна
		initialiseGL(); //Инициализация OpenGL - а
		initialiseGame(); // инициализация игры
		gameLoop(); //Основной игровой цикл
	}

	private static void initialiseGame() {
		game = new Game();
	}

	private static void gameLoop() {
		while(!Display.isCloseRequested()){
			getInput(); // Работа с вводом информации (клава, мышь)
			update(); //Просчет механических изменений объектов
			render(); //Просчет графики
			
		}
		cleanUp();
	}

	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT); //Очистка буфера цветов, очистка экрана;
		glLoadIdentity();
		game.render();
		Display.update();
		Display.sync(60);
	}

	private static void update() {
		game.getInput();
	}

	private static void getInput() {
		game.update();
	}

	private static void initialiseGL() {
		glMatrixMode(GL_PROJECTION); //Переход в матрицу перспективы
		glLoadIdentity(); //Избавляемся от всего, что могло быть на видеокарте (уже загруженно), сброс матриц
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1,1); // установка ортографической перспективы
		glMatrixMode(GL_MODELVIEW); //Переход в матрицу модели
		glDisable(GL_DEPTH_TEST); //Отключаем тест глубины (Не нужно для ортографическй перспективы)
		glClearColor(0, 0, 0, 0);
	}

	private static void initialiseDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGTH));
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
