package entities;

public class Route {
	private String link;
	private String description;
	private String image;
	private String name;
	private int city;
	private int id;
	private int rating;
	
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(String link, String description, String image, String name, int city, int id, int rating) {
		super();
		this.link = link;
		this.description = description;
		this.image = image;
		this.name = name;
		this.city = city;
		this.id = id;
		this.rating = rating;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Route [link=" + link + ", description=" + description + ", image=" + image + ", name=" + name
				+ ", city=" + city + ", id=" + id + ", rating=" + rating + "]";
	}
}
