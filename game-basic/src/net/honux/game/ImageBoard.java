package net.honux.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageBoard extends JPanel {

    private Image starNight;

    public ImageBoard() throws IOException {
        loadImage();
        setPreferredSize(new Dimension(starNight.getWidth(this), starNight.getHeight(this)));
    }

    private void loadImage() throws IOException {
        starNight = ImageIO.read(new File("./resources/starNight.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(starNight, 0, 0, null);
    }
}
