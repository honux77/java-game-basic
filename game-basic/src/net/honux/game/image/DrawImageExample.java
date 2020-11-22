package net.honux.game.image;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawImageExample extends JFrame {


    public DrawImageExample() throws IOException {
        initUI();
    }

    private void initUI() throws IOException {
        add(new ImageBoard());
        setTitle("Starring Night");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            DrawImageExample app = null;
            try {
                app = new DrawImageExample();
            } catch (IOException e) {
                e.printStackTrace();
            }
            app.setVisible(true);
        });
    }
}
