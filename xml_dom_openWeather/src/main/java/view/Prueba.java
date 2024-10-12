package view;

import java.util.ArrayList;

import model.Dia;
import parser.OpenWeather;

public class Prueba {

	public static void main(String[] args) {
		OpenWeather openWeather = new OpenWeather();
		ArrayList<Dia> dias = openWeather.getDias();
		
		for (Dia dia: dias) {
			System.out.println(dia);
		}
		
	}

}
