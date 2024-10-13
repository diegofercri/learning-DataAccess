package model;

public class Character {
    private String name;
    private String description;
    private Thumbnail thumbnail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Thumbnail: " + thumbnail.getPath() + "." + thumbnail.getExtension();
    }
}
