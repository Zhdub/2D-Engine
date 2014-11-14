package by.zti.engine.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureProcessor {
	public static Map<String, Texture> textures = new HashMap<String, Texture>();

	public static void loadTexture(String path, String name){
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG",
					ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textures.put(name, texture);
	}
	
	public static Texture getTexture(String name){
		return textures.get(name);
	}
	

}
