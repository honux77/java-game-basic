package net.honux.game.animation;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class SwingTimerEx extends JFrame {

    public SwingTimerEx() throws IOException {

        initUI();
    }

    private void initUI() throws IOException {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            SwingTimerEx ex = null;
            try {
                ex = new SwingTimerEx();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.setVisible(true);
        });
    }
}