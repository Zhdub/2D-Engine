package by.zti.engine.core;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.io.Serializable;

import by.zti.engine.core.render.Animation;
import by.zti.engine.core.render.Tile;

public class GameObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float x,y;
	protected float width, heigth;
	protected Tile tile;
	protected String name;
	protected int render_layer;
	protected boolean canCollide;

	public GameObject(float x, float y, float width, float heigth, Animation animation, String name, boolean canCollide, int render_layer) {
		tile = new Tile(animation);
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.name = name;
		this.canCollide = canCollide;
		this.render_layer = render_layer;
	}

	public void render() {
		glPushMatrix();
		{
			glTranslatef(x-Core.getCamera().getX()+Core.getCamera().getOffsetX(), y-Core.getCamera().getY()+Core.getCamera().getOffsetY(), 0);
			tile.render(width, heigth);
		}
		glPopMatrix();
	}
	
	public void update() {
		
	}
	
	public Tile getTile(){
		return tile;
	}
	
	public float getX(){
		return x;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeigth(){
		return heigth;
	}
	
	public String getName(){
		return name;
	}

	public int getRender_layer() {
		return render_layer;
	}

	public void setRender_layer(int render_layer) {
		this.render_layer = render_layer;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCanCollide() {
		return canCollide;
	}

	public void setCanCollide(boolean canCollide) {
		this.canCollide = canCollide;
	}
}
