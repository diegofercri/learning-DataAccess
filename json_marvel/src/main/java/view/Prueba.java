package view;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;

import model.Character;
import model.Result;

public class Prueba {
    public static void main(String[] args) {
        String urtTXT = "https://gateway.marvel.com/v1/public/characters?limit=100&offset=1&apikey=e894ad1f6af082d2b6b7a63ff20f35e0&hash=6faa0674ad5f8d6d7563ae9d0ad65dc9&ts=9";
        try {
            // traer JSON de internet a través de la URL en formato String
            URI uri = new URI(urtTXT);
            String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));

            // serializar
            Result result = new Gson().fromJson(jsonTxt, Result.class);

            // acceder a los personajes y mostrar nombre, descripción y thumbnail
            for (Character character : result.getData().getResults()) {
                System.out.println(character);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
