package by.zti.engine.core.render;

import java.io.Serializable;

import by.zti.engine.core.GameObject;

public class Camera implements Serializable{
	protected float x, y, offsetX, offsetY;
	protected GameObject object;
	protected float camSpeed;
	protected int camMode = 0;
	
	public Camera(float x, float y, float offsetX, float offsetY,float camSpeed, int camMode) {
		this.x = x;
		this.y = y;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.camSpeed = camSpeed;
		this.camMode = camMode;
	}
	
	public void bind(GameObject object){
		this.object=object;
//		this.x = object.getX();
//		this.y = object.getY();
	}
	
	public void update() {
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}
	
	public void switchCamMode(int camMode){
		this.camMode = camMode;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(float offsetX) {
		this.offsetX = offsetX;
	}

	public float getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(float offsetY) {
		this.offsetY = offsetY;
	}

	public int getCameraMode() {
		return camMode;
	}

	public void setCameraMode(int cameraMode) {
		this.camMode = cameraMode;
	}

}
