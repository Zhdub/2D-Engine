package by.zti.game;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Textures {
	public static Texture grass;
	public static Texture player;
	public static Texture cube;
	
	public static void initialise(){
		try {
			grass = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("grass.png"));
			player = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("player.png"));
			cube = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("cube.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
