package Lecture2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT =600;

    private final Sprite[] sprites = new Sprite[30];


    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
            sprites[0] = new Background();
        }
        MainCanvas canvas= new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }


    private void update(MainCanvas canvas, float deltaTime){
        for (Sprite sprite : sprites) {
            sprite.update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g){
        for (Sprite sprite : sprites) {
            sprite.render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }


}
