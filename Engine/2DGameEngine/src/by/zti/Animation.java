package by.zti;

import java.util.ArrayList;

public class Animation {
	private ArrayList<Frame> frames;
	private int currentFrame;
	
	public Animation(){
		frames = new ArrayList<Frame>();
	}
	
	public void render(){
		Frame tempFrame = frames.get(currentFrame);
		if(tempFrame.render()){
			currentFrame++;
			currentFrame %= frames.size();
		}
	}
}
