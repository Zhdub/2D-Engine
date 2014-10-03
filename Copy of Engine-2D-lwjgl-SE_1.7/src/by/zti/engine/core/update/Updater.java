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
				
				for (GameObject object : Core.getObjects()) {
					object.update();
				}
				Core.getRenderer().tick();
				isUpdateing = false;
			}
		}
		System.out.println(1);
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
