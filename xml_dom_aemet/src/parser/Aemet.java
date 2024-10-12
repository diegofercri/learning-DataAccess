package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Dia;

public class Aemet {
	
	private ArrayList<Dia> dias;
	
	public Aemet() {
		DOMParserWeb domParser = new DOMParserWeb("https://www.aemet.es/xml/municipios/localidad_45168.xml");
		Document doc = domParser.getDocumento();
		Dia dia;
		
		Element elementPredicion = (Element) doc.getElementsByTagName("prediccion").item(0);
		NodeList nodosDias = elementPredicion.getElementsByTagName("dia");
		
		dias = new ArrayList<Dia>();
		for (int i=0;i<nodosDias.getLength();i++) {
			Element nododia = (Element)nodosDias.item(i);
			dia = new Dia();
			dia.setFecha(nododia.getAttribute("fecha"));
			dia.setPreci(((Element) nododia.getElementsByTagName("prob_precipitacion").item(0)).getTextContent());
			Element cielo = (Element) nododia.getElementsByTagName("estado_cielo").item(0);
			dia.setIcono(cielo.getTextContent());
			dia.setProno(cielo.getAttribute("descripcion"));
			Element temp = (Element) nododia.getElementsByTagName("temperatura").item(0);
			dia.setMax(((Element) temp.getElementsByTagName("maxima").item(0)).getTextContent());
			dia.setMin(((Element) temp.getElementsByTagName("minima").item(0)).getTextContent());
			dias.add(dia);
		}
		
	}

	public ArrayList<Dia> getDias() {
		return dias;
	}
	

}
