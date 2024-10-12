package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dia {
	private String to;
	private String from;
	private String icono;
	private String preci;
	private String prono;
	private String max;
	private String min;
	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dia(String to, String from, String icono, String preci, String prono, String max, String min) {
		super();
		this.to = to;
		this.from = from;
		this.icono = icono;
		this.preci = preci;
		this.prono = prono;
		this.max = max;
		this.min = min;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date d=null;
		try {
			d = sdf1.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.to = sdf2.format(d);
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date d=null;
		try {
			d = sdf1.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.from = sdf2.format(d);
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
		return "Dia [to=" + to + ", from=" + from + ", icono=" + icono + ", preci=" + preci + ", prono=" + prono
				+ ", max=" + max + ", min=" + min + "]";
	}
	
	
}

