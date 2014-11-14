package by.zti.engine.core.render;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Textures {
	public static Map<String, Texture> textures = new HashMap<String, Texture>();

	public static void loadTextures(){
		try {
			Texture WIP = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/wip.png"));
			textures.put("WIP", WIP);
			Texture WIP2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/wip2.png"));
			textures.put("WIP2", WIP2);
			Texture Ground = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ground.png"));
			textures.put("ground", Ground);
			Texture Grass = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/grass.png"));
			textures.put("grass", Grass);
			Texture Stone = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/stone.png"));
			textures.put("stone", Stone);
			Texture Null = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/null.png"));
			textures.put("null", Null);
//			Texture Pad = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/pad.png"));
//			textures.put("pad", Pad);
//			Texture Pad2 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/pad2.png"));
//			textures.put("pad2", Pad2);
//			Texture BackGround = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/background.png"));
//			textures.put("background", BackGround);
//			Texture Ball = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ball.png"));
//			textures.put("ball", Ball);
//			Texture Wall = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/wall.png"));
//			textures.put("wall", Wall);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Texture getTexture(String name){
		return textures.get(name);
	}

}
