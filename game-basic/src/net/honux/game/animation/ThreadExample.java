package net.honux.game.animation;

import javax.swing.*;
import java.awt.*;

public class ThreadExample extends JFrame {

    public ThreadExample() {
        initUI();
    }

    private void initUI() {
        add(new ThreadBoard());
        setResizable(false);
        pack();

        setTitle("Thread Animation Example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new ThreadExample();
            ex.setVisible(true);
        });
    }
}
