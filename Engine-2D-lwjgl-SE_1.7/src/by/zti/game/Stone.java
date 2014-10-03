package by.zti.game;

import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;
import by.zti.engine.core.render.Animation;
import by.zti.engine.core.render.Frame;

public class Stone extends GameObject{
	private final static float WIDTH = 40;
	private final static float HEIGTH = 40;
	private int tipe;

	public Stone(float x, float y, Core core) {
		super(x, y, WIDTH, HEIGTH, new Animation(new Frame("stone", 10000000), 0, "still"), "Stone", true, core, RenderLayers.DECOR_LAYER);
		this.tipe = ObjectTypes.TYPE_STONE;
		MainCopmonent.map.put(this);
	}

	public int getTipe() {
		return tipe;
	}

	public void setTipe(int tipe) {
		this.tipe = tipe;
	}

}
