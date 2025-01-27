package entities;

public class Place {
	private int fav;
	private String image;
	private String name;
	private int category_id;
	private int province_id;
	private int id;
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Place(int fav, String image, String name, int category_id, int province_id, int id) {
		super();
		this.fav = fav;
		this.image = image;
		this.name = name;
		this.category_id = category_id;
		this.province_id = province_id;
		this.id = id;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
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
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Place [favourite=" + fav + ", image=" + image + ", name=" + name + ", category_id=" + category_id
				+ ", province_id=" + province_id + ", id=" + id + "]";
	}
}
