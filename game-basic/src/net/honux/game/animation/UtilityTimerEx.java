package net.honux.game.animation;

import javax.swing.*;
import java.awt.*;

public class UtilityTimerEx extends JFrame {

    public UtilityTimerEx() {

        initUI();
    }

    private void initUI() {

        add(new STimerBoard());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new UtilityTimerEx();
            ex.setVisible(true);
        });
    }
}