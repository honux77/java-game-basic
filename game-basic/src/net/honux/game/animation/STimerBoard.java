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
    private Image bg;
    private Timer timer;
    private int x, y;
    private int dx, dy;

    public STimerBoard() {

        initBoard();
    }

    private void loadImage() {
        try {
            star = ImageUtil.makeTransparent(
                    ImageIO.read(new File("./resources/slime.png")));

            bg = ImageIO.read(new File("./resources/starNight.jpg"));
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
        dx = 3;
        dy = 3;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBackground(g);
        drawStar(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(bg, 0, 0, this);
    }

    private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;

        if (y < 0 ||  y > this.getHeight() - star.getHeight(this)) {
            dy = -dy;
        }

        if (x < 0 || x > this.getWidth() - star.getWidth(this)) {
            dx = -dx;
        }

        repaint();
    }
}