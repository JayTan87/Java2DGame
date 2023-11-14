package com.example.java2dgame;
import javax.swing.JFrame;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH /12*9;
    public static final int SCALE = 3;
    public static final String NAME = "GAME";

    private JFrame frame;

    public boolean running = false;

    public Game() {
        setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.add(this,BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }

    public synchronized void stop() {
    running = false;
    }
    @Override
    public void run() {
    while(running) {
        System.out.println("Hello World");
    }
    }

    public static void main(String[] args) {
        new Game().start();
    }

}
