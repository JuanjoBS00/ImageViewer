package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

public class PrevCommand implements Command {
    
    private final List<Image> images;
    private final ImageDisplay imagesDisplay;

    public PrevCommand(List<Image> images, ImageDisplay imagesDisplay) {
        this.images = images;
        this.imagesDisplay = imagesDisplay;
    }
    
    @Override
    public void execute() {
        imagesDisplay.show(prev());
    }
    
    private Image prev(){
        int index = images.indexOf(imagesDisplay.image());
        return images.get((index-1+images.size()) % images.size());
    }
    
}