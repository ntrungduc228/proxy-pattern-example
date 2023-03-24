public class ProxyImage implements Image{
    private Image realImage;
    private String url;
    private String username;

    public ProxyImage(String url) {
        this.url = url;
        System.out.println("Image unloaded: " + this.url);
    }

    public ProxyImage(String url, String username) {
        this.url = url;
        this.username = username;
        System.out.println("Image unloaded: " + this.url);
    }

    @Override
    public void showImage() throws IllegalAccessException {
        if(User.isAdmin(username)){
            if (realImage == null) {
                realImage = new RealImage(this.url);
            } else {
                System.out.println("Image already existed: " + this.url);
            }
            realImage.showImage();
        }else {
            throw new IllegalAccessException("Access denied");

        }

    }
}