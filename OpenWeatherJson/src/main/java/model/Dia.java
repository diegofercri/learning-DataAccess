package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Dia {
	@SerializedName("main")
	private Temps temps;
	@SerializedName("weather")
	private List<IcoProno> icoProno;
	private int pop;
	@SerializedName("dt_txt")
	private String fecha;
}
