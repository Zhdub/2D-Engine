package by.zti.engine.core.update;

import java.io.Serializable;

import by.zti.engine.core.Core;

public class Updater implements Runnable, Serializable{
	private Core core;
	
	public Updater(Core core){
		this.core = core;
	}

	@Override
	public void run() {
		while(true){
			core.update();
		}
	}

}
