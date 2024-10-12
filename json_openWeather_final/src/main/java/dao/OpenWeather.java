package dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import model.Dia;
import model.Result;

public class OpenWeather {

	public OpenWeather() {
		super();
	}
	
	public List<Dia> getDias(){
		Result result = null;
		String urtTXT = "http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&units=metric&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp";
		try {
			// traer JSON de internet a través de la URL en formato String
			URI uri = new URI(urtTXT);
			String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));
			// serializar
			result = new Gson().fromJson(jsonTxt, Result.class);
			 
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.getList();

	}

	
}
