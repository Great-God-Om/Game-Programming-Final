package finalgame.lib.Engine;

import finalgame.lib.Engine.SceneManagement.SceneManager;
import finalgame.lib.GraphicsEngine.Renderer;
import finalgame.world.Scenes.World;

public class GameLoop {
	private static boolean running = false;
	private static int updates = 0;
	private static final int MAX_UPDATES = 5;
	private static long lastUpdateTime = 0;

	private static int targetFPS = 60;
	private static final int targetTime = 1000000000 / targetFPS;
	public static final float deltaTime = 1.0f / 1000000000 * targetTime;
	public static final SceneManager SCENE_MANAGER = new SceneManager();

	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				running = true;
				lastUpdateTime = System.nanoTime();
				while (running) {
					updates = 0;
					long currentTime = System.nanoTime();
					while ((currentTime - lastUpdateTime > targetTime) && updates < MAX_UPDATES) {
						World.update();
						lastUpdateTime += targetTime;
						updates++;
					}
					Renderer.render();
					long timeTaken = System.nanoTime() - currentTime;
					if (targetTime > timeTaken) {
						try {
							Thread.sleep((targetTime - timeTaken) / 1000000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};

		thread.setName("GameLoop");
		thread.start();
	}
}