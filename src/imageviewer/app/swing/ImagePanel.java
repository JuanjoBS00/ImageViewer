package imageviewer.app.swing;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ImagePanel extends JPanel implements ImageDisplay {

    private Image image;
    private BufferedImage data;

    public ImagePanel() throws IOException {
    }
    
    @Override
    public void paint(Graphics g){
        Box box = new Box(data.getWidth(), data.getHeight(), this.getWidth(), this.getHeight());
        g.drawImage(data, box.x, box.y, box.width, box.height , null);
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.data = read(new File(image.getName()));
        repaint();
    }

    @Override
    public Image image() {
        return this.image;
    }

    private BufferedImage read(File name) {
        try {
            return ImageIO.read(name);
        } catch (IOException ex) {
            return null;
        }
    }
    
    private static class Box {
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        private Box(int imageWidth, int imageHeight, int panelWidth, int panelHeight) {
            double imageRatio = imageWidth/imageHeight;
            double panelRatio = panelWidth/panelHeight;
            this.width = (int) (imageRatio >= panelRatio ? panelWidth : imageWidth*panelHeight/imageHeight);
            this.height = (int) (imageRatio <= panelRatio ? panelHeight : imageHeight*panelWidth/imageWidth);
            this.x = (int)((panelWidth - this.width) / 2);
            this.y = (int)((panelHeight - this.height) / 2);
        }
    }
    
    
    
}