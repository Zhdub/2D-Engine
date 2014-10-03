package by.zti.game;

import by.zti.engine.core.GameObject;
import by.zti.engine.core.render.Animation;
import by.zti.engine.core.render.Frame;

public class Grass extends GameObject {
	private final static float WIDTH = 40;
	private final static float HEIGTH = 40;
	private int type;

	public Grass(float x, float y) {
		super(x, y, WIDTH, HEIGTH, new Animation(new Frame("grass", 10000000), 0, "still"), "Grass", false, RenderLayers.GROUND_LAYER);
		this.type = ObjectTypes.TYPE_GRASS;
		MainCopmonent.map.put(this);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
