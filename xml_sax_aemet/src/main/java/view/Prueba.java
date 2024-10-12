package view;

import java.util.ArrayList;

import manejador.ManejadorWeb;
import model.Dia;

public class Prueba {

	public static void main(String[] args) {
		ManejadorWeb manejador = new ManejadorWeb("https://www.aemet.es/xml/municipios/localidad_45168.xml");
		ArrayList<Dia> dias = manejador.parsear();
		
		for (Dia dia:dias) {
			System.out.println(dia);
		}

	}


}
