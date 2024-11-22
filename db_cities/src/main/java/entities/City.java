package entities;

public class City {
	private String map;
	private String link;
	private String description;
	private String image;
	private String name;
	private int id;
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(String map, String link, String description, String image, String name, int id) {
		super();
		this.map = map;
		this.link = link;
		this.description = description;
		this.image = image;
		this.name = name;
		this.id = id;
	}
	
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "City [map=" + map + ", link=" + link + ", description=" + description + ", image=" + image + ", name=" + name + ", id=" + id
				+ "]";
	}
}
