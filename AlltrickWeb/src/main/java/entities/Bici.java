package entities;

public class Bici {
	private int id;
	private String foto;
	private int marca;
	private String descripcion;
	private float precio;
	private int fav;
	public Bici() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bici(int id, String foto, int marca, String descripcion, float precio, int fav) {
		super();
		this.id = id;
		this.foto = foto;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fav = fav;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "Bici [id=" + id + ", foto=" + foto + ", marca=" + marca + ", descripcion=" + descripcion + ", precio="
				+ precio + ", fav=" + fav + "]";
	}
	
}
