import java.util.concurrent.TimeUnit;

public class RealImage implements Image {
    public RealImage(String imageFilePath) throws InterruptedException {
        loadImage(imageFilePath);
    }
    private void loadImage(String imageFilePath) throws InterruptedException {
        System.out.println("loading..." + imageFilePath);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("loaded " + imageFilePath);
    }
    @Override
    public void showImage() {
        System.out.println("show real img");
    }
}
