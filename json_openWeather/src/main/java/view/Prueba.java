package view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.oracle.wls.shaded.org.apache.xml.utils.URI;

import model.Dia;
import model.Result;

public class Prueba {

	public static void main(String[] args) {
		String urtTXT = "http://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&units=metric&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp";
		try {
			// traer JSON de internet a través de la URL en formato String
			String jsonTxt = IOUtils.toString(new URL(urtTXT), Charset.forName("UTF-8"));
			//System.out.println(jsonTxt);
			// serializar
			Result result = new Gson().fromJson(jsonTxt, Result.class);
			
			for (Dia dia:result.getList()) {
				System.out.println(dia);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
