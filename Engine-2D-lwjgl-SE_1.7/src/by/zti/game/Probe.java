package by.zti.game;

import by.zti.engine.core.GameObject;
import by.zti.engine.core.render.Animation;
import by.zti.engine.core.render.Frame;

public class Probe extends GameObject {

	public Probe(float x, float y, float width, float heigth) {
		super(x, y, width, heigth, new Animation(new Frame("probe", 10000), 0, "none"), "Probe", false, MainCopmonent.core, RenderLayers.PLAYER_LAYER);
		MainCopmonent.map.put(this);
	}
	
	public void move(float x, float y){
		MainCopmonent.map.remove(this);
		setX(x);
		setY(y);
		MainCopmonent.map.put(this);
	}
}
