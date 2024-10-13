package dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;

import model.Character;
import model.Result;

public class Marvel {
    public Marvel() {
        super();
    }

    public List<Character> getCharacters() {
        Result result = null;
        String urtTXT = "https://gateway.marvel.com/v1/public/characters?limit=100&offset=1&apikey=e894ad1f6af082d2b6b7a63ff20f35e0&hash=6faa0674ad5f8d6d7563ae9d0ad65dc9&ts=9";
        try {
            URI uri = new URI(urtTXT);
            String jsonTxt = IOUtils.toString(uri.toURL(), Charset.forName("UTF-8"));
            result = new Gson().fromJson(jsonTxt, Result.class);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return result != null ? result.getData().getResults() : null;
    }
}
