package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Dia {
	@SerializedName("main")
	private Temps temps;
	@SerializedName("weather")
	private List<IcoProno> icoProno;
	private float pop;
	@SerializedName("dt_txt")
	private String fecha;
	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dia(Temps temps, List<IcoProno> icoProno, float pop, String fecha) {
		super();
		this.temps = temps;
		this.icoProno = icoProno;
		this.pop = pop;
		this.fecha = fecha;
	}
	public Temps getTemps() {
		return temps;
	}
	public void setTemps(Temps temps) {
		this.temps = temps;
	}
	public List<IcoProno> getIcoProno() {
		return icoProno;
	}
	public void setIcoProno(List<IcoProno> icoProno) {
		this.icoProno = icoProno;
	}
	public float getPop() {
		return pop;
	}
	public void setPop(float pop) {
		this.pop = pop;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Dia [temps=" + temps + ", icoProno=" + icoProno + ", pop=" + pop + ", fecha=" + fecha + "]";
	}
	

}
