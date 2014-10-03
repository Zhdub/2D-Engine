package by.zti.game;

import java.io.Serializable;
import java.util.ArrayList;

import by.zti.engine.Input;
import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;
import by.zti.engine.core.render.Animation;
import by.zti.engine.core.render.Frame;

public class WIP extends GameObject implements Serializable {
	private final static float WIDTH = 40;
	private final static float HEIGTH = 40;
	private int speed = 4;
	private int type;
	private boolean canMoveUp, canMoveDown, canMoveLeft, canMoveRight,
			moveingUp, moveingDown, moveingLeft, moveingRight;

	public WIP(float x, float y, Core core) {
		super(x, y, WIDTH, HEIGTH, new Animation(new Frame("WIP", 1000), 0,
				"WIP"), "WIP", false, core, RenderLayers.PLAYER_LAYER);
		this.getTile().getAnimation(0).addFrame(new Frame("WIP2", 1000));
		this.type = ObjectTypes.TYPE_WIP;
		MainCopmonent.map.put(this);

	}

	public void update() {
		checkCollision();
		movement();
	}

	private void checkCollision() {
		checkLeftCollision();
		checkUpCollision();
		checkDownCollision();
		checkRightCollision();
	}

	private void checkRightCollision() {
		ArrayList<GameObject> rightObjects = new ArrayList<GameObject>();
		for (float i = y; i < y + heigth; i++) {
			if (MainCopmonent.map.getCollision(x + width + 1, i) != null) {
				for (GameObject object : MainCopmonent.map.getCollision(x
						+ width + 1, i)) {
					if (!rightObjects.contains(object)) {
						rightObjects.add(object);
					}
				}
			}
		}
		for (GameObject object : rightObjects) {
			if (object.isCanCollide()) {
				canMoveRight = false;
				break;
			} else {
				canMoveRight = true;
			}
		}
		rightObjects.clear();
	}

	private void checkDownCollision() {
		ArrayList<GameObject> downObjects = new ArrayList<GameObject>();
		for (float i = x; i < x + width; i++) {
			if (MainCopmonent.map.getCollision(i, y - 1) != null) {
				for (GameObject object : MainCopmonent.map.getCollision(i,
						y - 1)) {
					if (!downObjects.contains(object)) {
						downObjects.add(object);
					}
				}
			}
		}
		for (GameObject object : downObjects) {
			if (object.isCanCollide()) {
				canMoveDown = false;
				break;
			} else {
				canMoveDown = true;
			}
		}
		downObjects.clear();

	}

	private void checkUpCollision() {
		ArrayList<GameObject> upObjects = new ArrayList<GameObject>();
		for (float i = x; i < x + width; i++) {
			if (MainCopmonent.map.getCollision(i, y + heigth + 1) != null) {
				for (GameObject object : MainCopmonent.map.getCollision(i, y
						+ heigth + 1)) {
					if (!upObjects.contains(object)) {
						upObjects.add(object);
					}
				}
			}
		}
		for (GameObject object : upObjects) {
			if (object.isCanCollide()) {
				canMoveUp = false;
				break;
			} else {
				canMoveUp = true;
			}
		}
		upObjects.clear();
	}

	private void checkLeftCollision() {
		ArrayList<GameObject> rightObjects = new ArrayList<GameObject>();
		for (float i = y; i < y + heigth; i++) {
			if (MainCopmonent.map.getCollision(x - 1, i) != null) {
				for (GameObject object : MainCopmonent.map.getCollision(x - 1,
						i)) {
					if (!rightObjects.contains(object)) {
						rightObjects.add(object);
					}
				}
			}
		}
		for (GameObject object : rightObjects) {
			if (object.isCanCollide()) {
				canMoveLeft = false;
				break;
			} else {
				canMoveLeft = true;
			}
		}
		rightObjects.clear();
	}

	public void move(float x, float y) {
		MainCopmonent.map.remove(this);
		setX(x);
		setY(y);
		MainCopmonent.map.put(this);
	}

	private void movement() {
		if (Input.getKey(Input.KEY_W) && canMoveUp) {
			MainCopmonent.map.remove(this);
			y += speed;
			MainCopmonent.map.put(this);
		}

		if (Input.getKey(Input.KEY_S) && canMoveDown) {
			MainCopmonent.map.remove(this);
			y -= speed;
			MainCopmonent.map.put(this);
		}

		if (Input.getKey(Input.KEY_A) && canMoveLeft) {
			MainCopmonent.map.remove(this);
			x -= speed;
			MainCopmonent.map.put(this);
		}

		if (Input.getKey(Input.KEY_D) && canMoveRight) {
			MainCopmonent.map.remove(this);
			x += speed;
			MainCopmonent.map.put(this);
		}
	}

	@Override
	public String toString() {
		return name + " [" + x + ", " + y + "]";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
