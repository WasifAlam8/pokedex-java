package dev.pokedex;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PokeApiClient {
    // String for the base of the link to access pokeAPI
    public static final String BASE = "https://pokeapi.co/api/v2/";
    // Creates the http client
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public JsonObject get(String url) throws IOException, InterruptedException {
        // Makes the request to PokeAPI
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Handles cases if url is not found or is not 200
        if (response.statusCode() == 404) return null;
        if (response.statusCode() != 200) throw new IOException("HTTP" + response.statusCode());

        // Returns JSON of the pokemon
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
}
