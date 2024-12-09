package entities;

public class Province {
	private String flyer;
	private String image;
	private String name;
	private int id;
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(String flyer, String image, String name, int id) {
		super();
		this.flyer = flyer;
		this.image = image;
		this.name = name;
		this.id = id;
	}
	public String getFlyer() {
		return flyer;
	}
	public void setFlyer(String flyer) {
		this.flyer = flyer;
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
		return "Province [flyer=" + flyer + ", image=" + image + ", name=" + name + ", id=" + id + "]";
	}
}
