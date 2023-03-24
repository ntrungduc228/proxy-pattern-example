public class ImageProxy implements Image {
    private String imageFilePath;
    private Image realImage;


    public ImageProxy(String imageFilePath) {
        this.imageFilePath= imageFilePath;
    }

    @Override
    public void showImage() throws InterruptedException {
        if(realImage == null) {
            realImage = new RealImage(imageFilePath);
        }
        realImage.showImage();
    }
}
