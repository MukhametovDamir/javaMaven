package lesson16;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

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
        res.setPassword(object.getJSONObject("login").getString("password"));
        res.setUsername(object.getJSONObject("login").getString("username"));
        res.setDob(ZonedDateTime.parse(object.getJSONObject("dob").getString("date")).toLocalDateTime());

        return res;
    }

    public static List<Peson> getPersonFromApi(int count) {

        List<Peson> pesons = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://randomuser.me/api")).build();
        try {
            for (int i = 0; i < count; i++) {
                HttpResponse<String> responsex
                        = client.send(request, HttpResponse.BodyHandlers.ofString());
                Peson peson = parseJsonToPerson(responsex);
                pesons.add(peson);
            }
            return pesons;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Peson> getPersons(int count) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create(String.format("https://randomuser.me/api?results=%d", count)))
                .build();
        try {
            HttpResponse<String> responsex = client.send(request, HttpResponse.BodyHandlers.ofString());

            List<Peson> pesons = jsonParser(responsex);
            return pesons;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Peson> jsonParser(HttpResponse<String> response) {
        List<Peson> res = new ArrayList<>();
        int count = new JSONObject(response.body()).getJSONObject("info")
                .getInt("results");

        for (int i = 0; i < count; i++) {
            JSONObject object
                    = new JSONObject(response.body())
                    .getJSONArray("results").getJSONObject(i);
            Peson peson = new Peson();
            peson.setName(object.getJSONObject("name").getString("first"));
            peson.setLastName(object.getJSONObject("name").getString("last"));
            peson.setCountry(object.getJSONObject("location").getString("country"));
            peson.setPassword(object.getJSONObject("login").getString("password"));
            peson.setUsername(object.getJSONObject("login").getString("username"));
            peson.setDob(ZonedDateTime.parse(object.getJSONObject("dob").getString("date")).toLocalDateTime());

            Supplier<Peson> qwe = () ->new Peson();
            res.add(peson);
        }
        return res;
    }
}
