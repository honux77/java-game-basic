package net.honux.game.animation;

import java.awt.*;
import java.awt.image.*;

public class ImageUtil {

    /**
     *
     * @param src Image want to make a selected color transparent
     * @param color The color of the image want to make transparent
     * @return Transparent image
     */
    public static Image makeTransparent(BufferedImage src, Color color) {

        int marker;
        if (color == null) {
            marker = src.getRGB(1, 1) | 0xFF000000;
        } else {
            marker = color.getRGB() | 0xFF000000;
        }

        ImageFilter filter = new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                //if the color is same as market, set alpha bit as zero - transparent
                if ((rgb | 0xFF000000) == marker) {
                    return rgb & 0x00FFFFFF;
                }
                return rgb;
            }
        };
        ImageProducer ip = new FilteredImageSource(src.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
