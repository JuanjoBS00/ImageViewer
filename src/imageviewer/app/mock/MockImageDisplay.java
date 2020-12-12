package imageviewer.app.mock;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;

public class MockImageDisplay implements ImageDisplay {
    
    private Image image;

    @Override
    public void show(Image image) {
        System.out.println(image.getName());
    }

    @Override
    public Image image() {
        return image;
    }

}
