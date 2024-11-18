package parser;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Dia;

public class OpenWeather {
	
	private ArrayList<Dia> dias;
	
	public OpenWeather() {
		DOMParserWeb domParser = new DOMParserWeb("https://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp&units=metric");
		Document doc = domParser.getDocumento();
		Dia dia;
		
		
		NodeList nodosTimes = doc.getElementsByTagName("time");
		
		dias = new ArrayList<Dia>();
		for (int i=0;i<nodosTimes.getLength();i++) {
			Element nodotime = (Element)nodosTimes.item(i);
			dia = new Dia();
			
			dia.setTo(nodotime.getAttribute("to"));
			dia.setFrom(nodotime.getAttribute("from"));
			
			Element elepreci = (Element) nodotime.getElementsByTagName("precipitation").item(0);
			dia.setPreci(elepreci.getAttribute("probability"));
			
			Element eletem = (Element) nodotime.getElementsByTagName("temperature").item(0);
			dia.setMax(eletem.getAttribute("max"));
			dia.setMin(eletem.getAttribute("min"));
			
			Element elesymbol = (Element) nodotime.getElementsByTagName("symbol").item(0);
			dia.setIcono(elesymbol.getAttribute("var"));
			
			Element eleclouds = (Element) nodotime.getElementsByTagName("clouds").item(0);
			dia.setProno(eleclouds.getAttribute("value"));
			
			
			dias.add(dia);
		}
		
	}

	public ArrayList<Dia> getDias() {
		return dias;
	}
	

}
