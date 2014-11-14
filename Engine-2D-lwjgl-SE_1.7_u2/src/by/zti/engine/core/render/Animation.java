package by.zti.engine.core.render;

import java.io.Serializable;
import java.util.ArrayList;

import by.zti.engine.core.Core;

public class Animation implements Runnable, Serializable{
	private ArrayList<Frame> frames;
	private boolean isAnimated, canBeAnimated;
	private int id;
	private String animationName;
	private Frame current_frame;
	
	public Animation(Frame frame, int id, String animationName){
		frames = new ArrayList<Frame>();
		frames.add(frame);
		current_frame = frame;
		this.id = id;
		this.setAnimationName(animationName);
		isAnimated = false;
		canBeAnimated = true;
	}
	
	public Animation(Frame frame, int id, String animationName, boolean canBeAnimated){
		frames = new ArrayList<Frame>();
		frames.add(frame);
		current_frame = frame;
		this.id = id;
		this.setAnimationName(animationName);
		isAnimated = false;
		this.canBeAnimated = canBeAnimated;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void render(float width, float heigth) {
		if(!isAnimated&&canBeAnimated){
			Core.getRenderer().getExecutor().submit(this);
		}
		current_frame.render(width, heigth);
	}
	
	public void reset(){
		isAnimated = false;
	}
	
	public void addFrame(Frame frame){
		frames.add(frame);
	}

	@Override
	public void run() {
		isAnimated = true;
		for(Frame frame: frames){
			current_frame = frame;
			try {
				Thread.sleep(frame.getDuration());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isAnimated = false;
		
	}

	public String getAnimationName() {
		return animationName;
	}

	public void setAnimationName(String animationName) {
		this.animationName = animationName;
	}
}
