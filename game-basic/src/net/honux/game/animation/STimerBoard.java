package net.honux.game.animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class STimerBoard extends JPanel
        implements ActionListener {

    private final int DELAY = 15;

    private Image slimes;
    private Image bg;
    private Timer timer;
    private int x, y;
    private int dx;
    private int frame = 0;
    private int xn = 5;

    public STimerBoard() {
        initBoard();
    }

    private void loadImage() {
        try {
            bg = ImageIO.read(new File("./resources/starNight.jpg"));
            slimes = ImageUtil.makeTransparent(
                    ImageIO.read(new File("./resources/slime_sprites.png")), null);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        loadImage();
        setPreferredSize(new Dimension(bg.getWidth(this), bg.getHeight(this)));


        x = 1;
        y = 400;
        dx = 3;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBackground(g);
        drawSlime(g);
        frame++;
    }

    private void drawBackground(Graphics g) {
        g.drawImage(bg, 0, 0, this);
    }

    private void drawSlime(Graphics g) {
        int hs = 28;
        int w = 32;
        int i = frame % 60 / 10;
        g.drawImage(slimes, x, y, x + w * xn, y + hs * xn,
                0, 32 * i, 32, 32 * i + hs, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;

        if (x < 0 || x > this.getWidth() - 32 * xn) {
            dx = -dx;
        }
        repaint();
    }
}