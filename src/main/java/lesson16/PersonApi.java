package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PersonApi {
    public static Peson getPersonFromApi() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://randomuser.me/api")).build();
        try {
            HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());

            Peson peson = parseJsonToPerson(responsex);
            return peson;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Peson parseJsonToPerson(HttpResponse<String> responsex) {
        JSONObject object = new JSONObject(responsex.body())
                .getJSONArray("results").getJSONObject(0);
        Peson res = new Peson();
        res.setName(object.getJSONObject("name").getString("first"));
        res.setLastName(object.getJSONObject("name").getString("last"));
        res.setCountry(object.getJSONObject("location").getString("country"));

        ///дополнить остольные поля

        return res;
    }
}
