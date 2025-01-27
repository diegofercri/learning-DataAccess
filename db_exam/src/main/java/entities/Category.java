package entities;

public class Category {
	private String image;
	private String name;
	private int id;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String image, String name, int id) {
		super();
		this.image = image;
		this.name = name;
		this.id = id;
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
		return "Category [image=" + image + ", name=" + name + ", id=" + id + "]";
	}
}
