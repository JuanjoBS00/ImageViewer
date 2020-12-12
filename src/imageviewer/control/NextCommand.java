package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

public class NextCommand implements Command {
    
    private final List<Image> images;
    private final ImageDisplay imagesDisplay;

    public NextCommand(List<Image> images, ImageDisplay imagesDisplay) {
        this.images = images;
        this.imagesDisplay = imagesDisplay;
    }
    
    @Override
    public void execute() {
        imagesDisplay.show(next());
    }
    
    private Image next(){
        int index = images.indexOf(imagesDisplay.image());
        return images.get((index+1) % images.size());
    }
    
}