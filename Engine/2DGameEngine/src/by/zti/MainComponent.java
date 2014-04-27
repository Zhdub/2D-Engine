package by.zti;

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
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import by.zti.game.Game;
import by.zti.game.Textures;

public class MainComponent {
	private static final int WIDTH = 800;
	private static final int HEIGTH = 600;
	private static Game game;
	
	public static void main(String[] args){
		init();
	}
	
	public static void init(){
		initialiseDisplay();  //������������� ����
		initialiseGL(); //������������� OpenGL - �
		initialiseGame(); // ������������� ����
		Textures.initialise();
		gameLoop(); //�������� ������� ����
	}

	private static void initialiseGame() {
		game = new Game();
	}

	private static void gameLoop() {
		while(!Display.isCloseRequested()){
			getInput(); // ������ � ������ ���������� (�����, ����)
			update(); //������� ������������ ��������� ��������
			render(); //������� �������
			
		}
		cleanUp();
	}

	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}

	private static void render() {
		glClear(GL_COLOR_BUFFER_BIT); //������� ������ ������, ������� ������;
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
		glEnable(GL_TEXTURE_2D);
		glClearColor(0, 0, 0, 0);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glViewport(0,0,Display.getWidth(),Display.getHeight());
		glMatrixMode(GL_PROJECTION); //������� � ������� �����������
		glLoadIdentity(); //����������� �� �����, ��� ����� ���� �� ���������� (��� ����������), ����� ������
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1,1); // ��������� ��������������� �����������
		glMatrixMode(GL_MODELVIEW); //������� � ������� ������
		glDisable(GL_DEPTH_TEST); //��������� ���� ������� (�� ����� ��� �������������� �����������)
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
