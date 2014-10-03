package by.zti.engine.core.render;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tile implements Serializable{
	private String tile_name;
	private ArrayList<Animation> animations;
	private int curren_animation_id;
	
	public Tile(Animation animation){
		tile_name = "WIP";
		animations = new ArrayList<Animation>();
		animations.add(animation);
		curren_animation_id = 0;
	}

	public void render(float width, float heigth) {
		for(Animation animation: animations){
			if(animation.getId()==curren_animation_id){
				animation.render(width, heigth);
				break;
			}
			JOptionPane.showMessageDialog(null, ("\n "
					+ "Animations list is empty or current animation ID is invalid"));
		}
	}
	
	public void addAnimation(Animation animation){
		animations.add(animation);
		JOptionPane.showMessageDialog(null, ("\n"
				+ "New animation added to tile '"+tile_name+"'"));
	}
	
	public void removeAnimation(Animation animation){
		try{
			animations.remove(animation);
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, ("\n"
					+ "No such animation in requested Tile"));
		}
	}
	
	public void removeAnimation(int animationId){
		for(Animation animation: animations){
			if(animation.getId()==animationId){
				animations.remove(animation);
				break;
			}
			JOptionPane.showMessageDialog(null, ("\n"
					+ "No such animation in requested Tile"));
		}
	}
	
	public Animation getAnimation(int id){
		return animations.get(id);
	}

	public ArrayList<Animation> getAnimations() {
		return animations;
	}

	public void setAnimations(ArrayList<Animation> animations) {
		this.animations = animations;
	}

}
