package JDBC.DataBaseClasses;

public class Images {
    private int Id;
    private String imageURL;

    public Images() {
    }

    public Images(int imageId, String imageURL) {
        this.Id = imageId;
        this.imageURL = imageURL;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "images{" +
               "imageId=" + Id +
               ", imageURL='" + imageURL + '\'' +
               '}';
    }
}
