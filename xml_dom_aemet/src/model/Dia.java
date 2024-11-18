package model;

public class Dia {
	private String fecha;
	private String icono;
	private String preci;
	private String prono;
	private String max;
	private String min;
	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dia(String fecha, String icono, String preci, String prono, String max, String min) {
		super();
		this.fecha = fecha;
		this.icono = icono;
		this.preci = preci;
		this.prono = prono;
		this.max = max;
		this.min = min;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getPreci() {
		return preci;
	}
	public void setPreci(String preci) {
		this.preci = preci;
	}
	public String getProno() {
		return prono;
	}
	public void setProno(String prono) {
		this.prono = prono;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "Dia [fecha=" + fecha + ", icono=" + icono + ", preci=" + preci + ", prono=" + prono + ", max=" + max
				+ ", min=" + min + "]";
	}
	
}

