package gui;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Window extends JFrame {

    private static final int NUMCELLSX = 70;
    private static final int NUMCELLSY = 50;
    private static final int CELLWIDTH = 15;

    GameCanvas canvas;

    public Window(Game game, Consumer<Integer> setStepTimeDelta) {
        super();
        setSize(NUMCELLSX*CELLWIDTH, NUMCELLSY*CELLWIDTH);
        canvas = new GameCanvas(NUMCELLSX, NUMCELLSY, CELLWIDTH, game);
        canvas.setLayout(new GridBagLayout());
        add(canvas);

        /*JSlider deltaSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);
        deltaSlider.setSize(new Dimension(100, 100));
        deltaSlider.setPaintTicks(true);
        deltaSlider.setPaintLabels(true);
        deltaSlider.addChangeListener((e) -> {setStepTimeDelta.accept(1000 / deltaSlider.getValue()); });
        canvas.add(deltaSlider);*/

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void update() {
        canvas.repaint();
    }
}
