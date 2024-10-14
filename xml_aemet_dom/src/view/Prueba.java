package view;

import java.util.ArrayList;

import model.Dia;
import parser.Aemet;

public class Prueba {

	public static void main(String[] args) {
		Aemet aemet = new Aemet();
		ArrayList<Dia> dias = aemet.getDias();
		
		for (Dia dia: dias) {
			System.out.println(dia);
		}
		
	}

}
