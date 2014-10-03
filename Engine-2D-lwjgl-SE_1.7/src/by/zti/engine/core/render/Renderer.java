package by.zti.engine.core.render;

import by.zti.engine.core.Core;

public class Renderer implements Runnable {
	private Core core;
	private boolean isRendering;

	public Renderer(Core core) {
		this.core = core;
		isRendering = false;
		new Thread(this).start();
	}

	public void tick(Core core) {
		isRendering = true;
	}

	@Override
	public void run() {
		while (true) {
			if (isRendering) {
				core.render();
				isRendering = false;
			}
		}

	}

	private void cleanUp() {

	}

}
