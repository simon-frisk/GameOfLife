package gui;

import game.Game;

public class GUI implements Runnable {

    private int updateDelta = 100;
    private final Window window;
    private final Game game;

    public GUI(Game game) {
        window = new Window(game, (delta) -> { setUpdateDelta(delta); });
        this.game = game;
        this.run();
    }

    public void setUpdateDelta(int updateDelta) {
        this.updateDelta = updateDelta;
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();

        while(true) {
            long currentTime = System.currentTimeMillis();
            long delta = (currentTime - lastTime);

            if(delta > updateDelta) {
                lastTime = currentTime;
                update();
            }
        }
    }

    public void update() {
        game.step();
        window.update();
    }
}
