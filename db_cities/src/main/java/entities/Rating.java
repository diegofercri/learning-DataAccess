package entities;

public class Rating {
	private int points;
	private int route;
	private int id;
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int points, int route, int id) {
		super();
		this.points = points;
		this.route = route;
		this.id = id;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getRoute() {
		return route;
	}
	public void setRoute(int route) {
		this.route = route;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Point [points=" + points + ", route=" + route + ", id=" + id + "]";
	}
}
