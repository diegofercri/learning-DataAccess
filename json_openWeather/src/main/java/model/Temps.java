package model;

public class Temps {
	private float temp_min;
	private float temp_max;
	public Temps() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Temps(float temp_min, float temp_max) {
		super();
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	public float getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	public float getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	@Override
	public String toString() {
		return "Temps [temp_min=" + temp_min + ", temp_max=" + temp_max + "]";
	}
	
}
