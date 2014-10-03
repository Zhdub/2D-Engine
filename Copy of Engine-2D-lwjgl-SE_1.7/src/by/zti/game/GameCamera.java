package by.zti.game;

import java.io.Serializable;

import by.zti.engine.core.render.Camera;

public class GameCamera extends Camera implements Serializable {

	public GameCamera(float offsetX, float offsetY,
			float camSpeed, int camMode) {
		super(0, 0, offsetX, offsetY, camSpeed, camMode);
		
	}

	@Override
	public void update() {
		if(camMode==0){
			if(x>object.getX()){
				x-=camSpeed;
			}
			if(x<object.getX()){
				x+=camSpeed;
			}
			if(y>object.getY()){
				y-=camSpeed;
			}
			if(y<object.getY()){
				y+=camSpeed;
			}
		}else if(camMode==1){
			if(object.getX()-x>=250){
				x+=camSpeed;
			}
			if(x-object.getX()>=250){
				x-=camSpeed;
			}
			if(object.getY()-y>=150){
				y+=camSpeed;
			}
			if(y-object.getY()>=150){
				y-=camSpeed;
			}
		}
	}
	
	

}
