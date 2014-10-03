package by.zti.engine.core.render;

import java.io.Serializable;
import java.util.ArrayList;

public class Animation implements Runnable, Serializable{
	private ArrayList<Frame> frames;
	private boolean isAnimated;
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
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void render(float width, float heigth) {
		if(!isAnimated){
			new Thread(this).start();
		}
		current_frame.render(width, heigth);
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
