package by.zti.engine.core.update;

import org.lwjgl.input.Keyboard;

import by.zti.engine.Input;
import by.zti.engine.core.Core;
import by.zti.engine.core.GameObject;

public class Updater implements Runnable {
	private boolean isUpdateing;

	@Override
	public void run() {
		isUpdateing = true;
		while (!Keyboard.isCreated()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (Core.isRunning()) {
			if(isUpdateing){
				Input.update();
				for (GameObject object : Core.getQueue()) {
					object.update();
					if(Core.getCamera()!=null){
						Core.getCamera().update();	
					}
//					if(Core.getMap()!=null){
//						Core.getMap().update();
//					}
				}
				Core.getRenderer().tick();
				isUpdateing = false;
			}
		}
	}
	
	public void tick(){
		if(!isUpdateing){
			isUpdateing = true;
		}
	}

	public boolean isUpdateing() {
		return isUpdateing;
	}

	public void setUpdateing(boolean isUpdateing) {
		this.isUpdateing = isUpdateing;
	}

}
