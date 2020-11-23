package net.honux.game.animation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class STimerBoard extends JPanel
        implements ActionListener {

    private final int DELAY = 15;

    private Image star;
    private Image slimes;
    private Image bg;
    private Timer timer;
    private int x, y;
    private int dx, dy;
    private int frame = 0;

    public STimerBoard() {

        initBoard();
    }

    private void loadImage() {
        try {
            star = ImageUtil.makeTransparent(
                    ImageIO.read(new File("./resources/slime.png")));

            bg = ImageIO.read(new File("./resources/starNight.jpg"));
            slimes = ImageUtil.makeTransparent(
                    ImageIO.read(new File("./resources/slime_sprites.png")));

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void initBoard() {

        setBackground(Color.BLACK);
        loadImage();
        setPreferredSize(new Dimension(bg.getWidth(this), bg.getHeight(this)));


        x = this.getHeight() / 2;
        y = this.getWidth() / 2;
        dx = 2;
        dy = 2;

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

        switch (frame % 60 / 20) {
            case 0:
                g.drawImage(slimes, x, y, x + 64, y + 50, 0, 0, 32, 25, this);
                break;
            case 1:
                g.drawImage(slimes, x, y, x + 64, y + 42, 0, 36, 32, 57, this);
                break;
            case 2:
                g.drawImage(slimes, x, y, x + 64, y + 44, 0, 66, 32, 88, this);
                break;
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;

        if (y < 0 ||  y > this.getHeight() - 32) {
            dy = -dy;
        }

        if (x < 0 || x > this.getWidth() - slimes.getWidth(this)) {
            dx = -dx;
        }

        repaint();
    }
}